package main.btree;

import java.util.ArrayList;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

    protected BNode<T> root;
    protected int order;

    public BTreeImpl(int order) {
        this.order = order;
        this.root = new BNode<T>(order);
    }

    @Override
    public BNode<T> getRoot() {
        return this.root;
    }

    @Override
    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    @Override
    public int height() {
        return height(this.root);
    }

    private int height(BNode<T> node) {
        int height = -1;

        if (node != null && !node.isEmpty()) {
            if (node.isLeaf()) {
                height = 0;
            } else {
                height = 1 + this.height(node.getChildren().get(0));
            }
        }

        return height;
    }

    @Override
    public BNode<T>[] depthLeftOrder() {
        ArrayList<BNode<T>> array = new ArrayList<>();
        this.depthLeftOrder(this.root, array);

        return array.toArray(new BNode[array.size()]);
    }

    private void depthLeftOrder(BNode<T> node, ArrayList<BNode<T>> array) {
        if (!node.isEmpty()) {
            array.add(node);

            for (int i = 0; i < node.getChildren().size(); i++) {
                this.depthLeftOrder(node.getChildren().get(i), array);
            }
        }
    }

    @Override
    public int size() {
        return this.size(this.root);
    }

    private int size(BNode<T> node) {
        int size = 0;

        if (!node.isEmpty()) {
            size += node.size();

            for (int i = 0; i < node.getChildren().size(); i++) {
                size += this.size(node.getChildren().get(i));
            }
        }

        return size;
    }

    @Override
    public BNodePosition<T> search(T element) {
        BNodePosition<T> returnValue = new BNodePosition<T>();

        if (element != null) {
            returnValue = this.search(element, this.root);
        }

        return returnValue;
    }

    private BNodePosition<T> search(T element, BNode<T> node) {
        int index = 0;

        while (index < node.getElements().size() && node.getElementAt(index).compareTo(element) < 0) {
            index++;
        }

        BNodePosition<T> returnValue = null;

        if (index < node.getElements().size() && node.getElementAt(index).equals(element)) {
            returnValue = new BNodePosition<>(node, index);
        } else if (node.isLeaf()) {
            returnValue = new BNodePosition<>();
        } else {
            returnValue = search(element, node.getChildren().get(index));
        }

        return returnValue;
    }

    @Override
    public void insert(T element) {
        if (element != null) {
            this.insert(element, this.root);
        }
    }

    private void insert(T element, BNode<T> node) {
        int index = 0;

        while (index < node.getElements().size() && node.getElementAt(index).compareTo(element) < 0) {
            index++;
        }

        if (index >= node.getElements().size() || !node.getElementAt(index).equals(element)) {
            if (node.isLeaf()) {
                node.addElement(element);
            } else {
                this.insert(element, node.getChildren().get(index));
            }
        }

        if (node.getMaxKeys() < node.size()) {
            this.split(node);
        }

    }

    private void split(BNode<T> node) {
        int medianIndex = node.getElements().size() / 2;
        BNode<T> rightNode = new BNode<>(this.order);
        BNode<T> leftNode = new BNode<>(this.order);

        for (int i = 0; i < node.size(); i++) {
            if (i < medianIndex) {
                leftNode.addElement(node.getElementAt(i));
            } else if (i > medianIndex) {
                rightNode.addElement(node.getElementAt(i));
            }
        }

        T medianValue = node.getElementAt(medianIndex);

        if (!node.isLeaf()) {

            for (int i = 0, leftIndex = 0, rightIndex = 0; i < node.getChildren().size(); i++) {
                if (i <= medianIndex) {
                    leftNode.addChild(leftIndex++, node.getChildren().get(i));
                } else {
                    rightNode.addChild(rightIndex++, node.getChildren().get(i));
                }
            }

        }

        if (node.equals(this.getRoot())) {
            BNode<T> newRoot = new BNode<>(this.order);
            newRoot.addElement(medianValue);
            node.setParent(newRoot);
            this.root = newRoot;

            newRoot.addChild(0, leftNode);
            newRoot.addChild(1, rightNode);
            newRoot.getChildren().get(0).setParent(newRoot);
            newRoot.getChildren().get(1).setParent(newRoot);

        } else {
            node.addChild(0, leftNode);
            node.addChild(1, rightNode);
            promote(node);
        }
    }

    private void promote(BNode<T> node) {
        T medianValue = node.getElementAt(node.getElements().size() / 2);

        node.getElements().clear();
        node.addElement(medianValue);
        BNode<T> parentNode = node.getParent();

        if (parentNode != null) {
            node.getChildren().get(0).setParent(parentNode);
            node.getChildren().get(1).setParent(parentNode);

            int index = parentNode.getChildren().indexOf(node);

            parentNode.addElement(medianValue);
            parentNode.addChild(index++, node.getChildren().get(0));
            parentNode.addChild(index++, node.getChildren().get(1));

            node.getChildren().get(0).setParent(parentNode);
            node.getChildren().get(1).setParent(parentNode);

            parentNode.getChildren().remove(node);
        }
    }

    // NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
    @Override
    public BNode<T> maximum(BNode<T> node) {
        // NAO PRECISA IMPLEMENTAR
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

    @Override
    public BNode<T> minimum(BNode<T> node) {
        // NAO PRECISA IMPLEMENTAR
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

    @Override
    public void remove(T element) {
        // NAO PRECISA IMPLEMENTAR
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

}

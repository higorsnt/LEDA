package adt.btree;

import java.util.ArrayList;
import java.util.List;

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
      int result;

      if (this.isEmpty()) {
         result = -1;
      } else {
         result = height(this.root);
      }

      return result;
   }

   private int height(BNode<T> node) {
      int result = 0;

      if (!node.isLeaf()) {
         result = 1 + height(node.getChildren().getFirst());
      }

      return result;
   }

   @Override
   public BNode<T>[] depthLeftOrder() {
      List<BNode<T>> list = new ArrayList<>();
      BNode<T>[] array = new BNode[this.size() - 1];

      depthLeftOrder(this.root, list);

      return list.toArray(array);
   }

   private void depthLeftOrder(BNode<T> node, List<BNode<T>> list) {
      list.add(node);

      for (BNode<T> aux : node.getChildren()) {
         depthLeftOrder(aux, list);
      }
   }

   @Override
   public int size() {
      return this.size(this.root);
   }

   private int size(BNode<T> node) {
      int size = 0;

      if (!node.isLeaf()) {
         for (BNode<T> aux : node.getChildren()) {
            size += size(aux);
         }
      }

      return node.size() + size;
   }

   @Override
   public BNodePosition<T> search(T element) {
      return search(this.root, element);
   }

   public BNodePosition<T> search(BNode<T> node, T element) {
      BNodePosition<T> result = new BNodePosition<T>();

      int index = node.getElements().indexOf(element);

      if (index != -1) {
         result = new BNodePosition<>(node, index);
      } else {
         for (BNode<T> aux : node.getChildren()) {
            if (result.node == null) {
               result = search(aux, element);

            }
         }
      }

      return result;
   }

   @Override
   public void insert(T element) {
      if (element != null && this.search(element).node == null) {
         insert(this.root, element);
      }
   }

   private void insert(BNode<T> node, T element) {
      if (node.isFull()) {
         split(node);
         if (node.getParent() != null)
            node = node.getParent();
      }
      if (node.getChildren().isEmpty()) {
         node.addElement(element);
      } else {
         int i;
         for (i = 0; i < node.size(); i++) {
            T e = node.getElements().get(i);
            if (e.compareTo(element) > 0) {
               insert(node.getChildren().get(i), element);
               break;
            }
         }
         if (i == node.size()) {
            while (node.getChildren().size() <= i) {
               BNode<T> newNode = new BNode<>(this.order);
               newNode.setParent(node);
               node.getChildren().add(newNode);
            }
            insert(node.getChildren().get(i), element);
         }
      }
   }

   private void split(BNode<T> node) {
      BNode<T> right = new BNode<>(this.order);
      BNode<T> left = new BNode<>(this.order);

      T middle = node.getElements().get((this.order - 1) / 2);
      boolean addInLeft = true;
      for (T e : node.getElements()) {
         if (e.equals(middle)) {
            addInLeft = false;
         } else if (addInLeft) {
            left.addElement(e);
         } else {
            right.addElement(e);
         }
      }

      if (!node.equals(this.root)) {
         promote(node, left, right);
      } else {
         for (int i = 0; i < node.getChildren().size(); i++) {
            if (i <= (this.order - 1) / 2) {
               left.addChild(i, node.getChildren().get(i));
            } else {
               right.addChild(i - ((this.order - 1) / 2) - 1, node.getChildren().get(i));
            }
         }
         left.setParent(node);
         right.setParent(node);

         node.getChildren().clear();
         node.addChild(0, left);
         node.addChild(1, right);

         node.getElements().clear();
         node.addElement(middle);
      }
   }

   private void promote(BNode<T> node, BNode<T> leftChild, BNode<T> rightChild) {
      BNode<T> parent = node.getParent();
      T element = node.getElementAt((order - 1) / 2);
      parent.addElement(element);

      int position = parent.getElements().indexOf(element);
      parent.removeChild(node);

      leftChild.setParent(parent);
      rightChild.setParent(parent);

      node.parent.removeChild(node);
      node.parent.addChild(position, rightChild);
      node.parent.addChild(position, leftChild);
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

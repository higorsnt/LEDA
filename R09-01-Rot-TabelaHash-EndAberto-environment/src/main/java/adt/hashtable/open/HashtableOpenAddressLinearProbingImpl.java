package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
        AbstractHashtableOpenAddress<T> {

    public HashtableOpenAddressLinearProbingImpl(int size,
                                                 HashFunctionClosedAddressMethod method) {
        super(size);
        hashFunction = new HashFunctionLinearProbing<T>(size, method);
        this.initiateInternalTable(size);
    }

    private int getHash(T element, int probe) {
        return Math.abs(((HashFunctionOpenAddress<T>) super.hashFunction).hash(element, probe));
    }

    @Override
    public void insert(T element) {
        if (element != null && this.search(element) == null) {

            if (super.isFull()) throw new HashtableOverflowException();

            int i = 0;
            boolean inserted = false;
            int hash;

            while (!inserted) {
                hash = this.getHash(element, i++);

                if (super.table[hash] == null
                        || super.table[hash].equals(super.deletedElement)) {
                    super.table[hash] = element;
                    inserted = true;
                    super.elements++;
                } else {
                    super.COLLISIONS++;
                }
            }
        }
    }

    @Override
    public void remove(T element) {
        if (element != null && !(super.isEmpty())) {
            int hash;
            boolean found = false;
            int i = 0;

            while (!found && i < super.table.length) {
                hash = this.getHash(element, i);

                if (super.table[hash] == null) {
                    found = true;
                } else if (super.table[hash].equals(element)) {
                    super.table[hash] = super.deletedElement;
                    found = true;
                    super.elements--;
                    super.COLLISIONS -= i;
                }

                i++;
            }
        }
    }

    @Override
    public T search(T element) {
        T result = null;

        if (element != null && !(super.isEmpty())) {
            int hash = this.indexOf(element);

            if (hash != -1) {
                result = (T) super.table[hash];
            }
        }

        return result;
    }

    @Override
    public int indexOf(T element) {
        int index = -1;

        if (element != null && !(super.isEmpty())) {
            int hash;
            boolean found = false;
            int i = 0;

            while (!found && i < super.table.length) {
                hash = this.getHash(element, i++);

                if (super.table[hash] == null
                        || super.table[hash].equals(super.deletedElement)) {
                    found = true;
                } else if (super.table[hash].equals(element)) {
                    index = hash;
                    found = true;
                }
            }
        }

        return index;
    }

}

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
        return Math.abs(((HashFunctionOpenAddress) this.hashFunction).hash(element, probe));
    }

    @Override
    public void insert(T element) {
        if (this.isFull()) throw new HashtableOverflowException();

        if (element != null) {
            int i = 0;
            boolean inserted = false;
            int hash;

            while (!inserted) {
                hash = this.getHash(element, i++);

                if (this.table[hash] == null || this.table[hash].equals(this.deletedElement)) {
                    this.table[hash] = element;
                    inserted = true;
                    this.elements++;
                } else {
                    this.COLLISIONS++;
                }
            }
        }
    }

    @Override
    public void remove(T element) {
        if (element != null && !(this.isEmpty())) {
            int hash;
            boolean found = false;
            int i = 0;

            while (!found && i < this.table.length) {
                hash = this.getHash(element, i++);

                if (this.table[hash] == null) {
                    found = true;
                } else if (this.table[hash].equals(element)) {
                    this.table[hash] = this.deletedElement;
                    found = true;
                    this.elements--;
                }
            }
        }
    }

    @Override
    public T search(T element) {
        T result = null;

        if (element != null && !(this.isEmpty())) {
            int hash;
            boolean found = false;
            int i = 0;

            while (!found && i < this.table.length) {
                hash = this.getHash(element, i++);

                if (this.table[hash] == null) {
                    found = true;
                } else if (this.table[hash].equals(element)) {
                    result = (T) this.table[hash];
                    found = true;
                }
            }
        }

        return result;
    }

    @Override
    public int indexOf(T element) {
        int index = -1;

        if (element != null && !(this.isEmpty())) {
            int hash;
            boolean found = false;
            int i = 0;

            while (!found && i < this.table.length) {
                hash = this.getHash(element, i++);

                if (this.table[hash] == null) {
                    found = true;
                } else if (this.table[hash].equals(element)) {
                    index = hash;
                    found = true;
                }
            }
        }

        return index;
    }

}

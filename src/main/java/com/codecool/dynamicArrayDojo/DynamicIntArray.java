package com.codecool.dynamicArrayDojo;


// put your code here!
public class DynamicIntArray {

    private int[] storage;

    DynamicIntArray() {
        this.storage = new int[0];
    }

    DynamicIntArray(int initialSize) {
        int[] temporaryStorage = new int[initialSize];
        storage = temporaryStorage;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int aStorage : storage) {
            result.append(" ").append(aStorage);
        }
        return result.toString();
    }

    void add(int number) {
        int[] temporaryStorage = new int[storage.length + 1];
        for (int i = 0; i < storage.length; i++) {
            temporaryStorage[i] = storage[i];
            if (i == storage.length-1) {
                temporaryStorage[i+1] = number;
            }
        }
        storage = temporaryStorage;
    }

    void remove(int number) {
        int occurrenceCounter = 0;
        for (int aStorage : storage) {
            if (aStorage == number) {
                occurrenceCounter++;
            }
        }

        if (occurrenceCounter == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int[] temporaryStorage = new int[storage.length - occurrenceCounter];
        int temporaryStorageIndex = 0;
        for (int aStorage : storage) {
            if (aStorage != number) {
                temporaryStorage[temporaryStorageIndex] = aStorage;
                temporaryStorageIndex++;
            }
        }
        storage = temporaryStorage;
    }

    void insert(int index, int number) {
        int[] temporaryStorage = new int[storage.length + 1];

        if (temporaryStorage.length < index){
            index = temporaryStorage.length-1;
        }

        int change = 0;
        for (int i = 0; i < temporaryStorage.length; i++) {
            if (index == i) {
                temporaryStorage[i] = number;
                change++;
            } else {
                temporaryStorage[i] = storage[i - change];
            }
        }

        storage = temporaryStorage;
    }
}

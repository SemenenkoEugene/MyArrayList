package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<T> {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();

    }

    private T[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <=0");
        } else {
            list = (T[]) new Object[capacity];
        }
    }

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void addElement(T element) {
        checkCapacity();
        list[size] = element;
        size++;
    }

    public void addElement(int index, T element) {
        checkCapacity();
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = element;
        size++;
    }

    public void deleteElementByIndex(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
    }

    public void deleteElement(T element) {
        int pos = index(element);

        if (pos < 0) {
            throw new NoSuchElementException("Element not found");
        }
        deleteElementByIndex(pos);
    }

    public T get(int index) {
        if (index >= 0 && index < list.length) {
            return list[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("The index goes outside the array");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDisplay() {
        for (T elem : list) {
            System.out.print(elem + " ");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(list) +
                " size=" + size;
    }

    private void checkCapacity() {
        if (size == capacity) {
            T[] newArray = (T[]) new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = list[i];
            }
            list = newArray;
            capacity *= 2;
        }
    }

    private int index(T element) {
        if (element == null) {
            return -1;
        }

        for (int i = 0; i < size; i++) {
            if (element.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }
}

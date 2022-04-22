package com.company;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        arr = new Object[capacity];
    }


    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (index > length){
            increaseCapacity();
        }
        if (length == capacity)
            increaseCapacity();

        for (int i = length; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = item;
    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public T remove(int index) {
        if (index+1 == length){
            arr[index] = null;
            length--;
            return null;
        }
        if (index < size()){
            arr[index] = null;
            int tmp = index;
            while (tmp < size()){
                arr[tmp] = arr[tmp+1];
                arr[tmp+1] = null;
                tmp++;
            }
            length--;
        }
        return null;
    }

    @Override
    public void clear() {
        length = 0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index) {
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        int a = 0;
        for (int i = 0; i < length; i++){
            if (arr[i].equals(o)){
                a = i;
            }
        }
        return a;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = length - 1;
        return (int) arr[i];
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                T first = (T) arr[j];
                T second = (T) arr[j+1];
                if (first.compareTo(second) > 0) {
                    Object t = (Object) arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;

                }
            }
        }
    }
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return "" + Arrays.stream(arr).filter(Objects::nonNull).toList();
    }
}


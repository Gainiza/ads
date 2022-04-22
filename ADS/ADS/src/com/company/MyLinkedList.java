package com.company;

public class MyLinkedList<T extends Comparable<T> > implements MyList<T> {
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {}

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        if (index >= length){
            throw new IndexOutOfBoundsException("Must be positive and less than size");
        }
        MyNode<T> newNode = new MyNode<>(item);
        MyNode<T> count = head;
        while ( index != 0){
            count = count.next;
            index--;
        }
        count.prev.next = newNode;
        newNode.next = count.next;
        length++;

    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {
    head = null;
    length= 0;
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        MyNode<T> t = head;
        int index = 0;
        while (index != length-1){
            if(t.data == o){
                return index;
            }
            t = t.next;
            index++;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> t = head;
        int index = length-1;
        while (index != 0){
            if(t.data == o){
                return index;
            }
            t = t.next;
            index--;
        }
        return 0;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (get(j).compareTo(get(j+1)) > 0) {
                    Object t = getN(j);
                    getN(j).data = getN(j+1).data;
                    getN(j+1).data = (T) t;

                }
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        MyNode<T> word = head;
        for (int i = 0; i<length-1; i++){
            if (word.data == o){
                return true;
            }
            word = word.next;
        }
        return false;
    }
    public MyNode<T> getN (int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp;
    }
}

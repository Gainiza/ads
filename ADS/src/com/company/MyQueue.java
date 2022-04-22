package com.company;

import java.util.Arrays;
import java.util.Objects;

public class MyQueue<T extends Comparable<T>>{
    private final Object[] queue;
    private static int front, back, capacity;


    public MyQueue(int size){
        front = back = 0;
        capacity = size;
        queue = new Object[capacity + 1];
    }

    public void add(T element) {
        if (back == capacity) return;

        queue[back] = element;
        back++;
    }

    public T get(int element) {
        return (T) queue[element];
    }

    public void remove(){
        if (front == back) return;

        if (back - 1 + 1 >= 0) System.arraycopy(queue, 1, queue, 0, back - 1 + 1);

        if (back < capacity) queue[back] = null;
        back--;
    }

    public Object peek(){
        if (front == back) return null;

        return queue[front];
    }

    public Object poll(){
        if (front == back) return null;
        Object tmp = queue[front];
        remove();
        return tmp;
    }


    @Override
    public String toString() {
        return "" + Arrays.stream(queue).filter(Objects::nonNull).toList();
    }
}

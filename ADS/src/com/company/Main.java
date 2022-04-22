package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>(5);

        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);

        System.out.println(myQueue + " - myQueue add()");
        myQueue.remove();
        myQueue.remove();
        System.out.println(myQueue + " - myQueue - remove()");

        System.out.println(myQueue.poll() + " - myQueue poll()");
        System.out.println(myQueue + " - result of poll()");
        System.out.println(myQueue.peek() + " - myQueue peek()");

        System.out.println("----------");

        MyStack<Integer> myStack = new MyStack<Integer>();

        System.out.println(myStack.empty() + " - myStack empty()");
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack + " - myStack push()");
        System.out.println(myStack.peek() + " - myStack peek()");
        System.out.println(myStack.pop() + " - myStack pop()");
        System.out.println(myStack + " - result of pop()");

        System.out.println("------------");
        MyHeap maxHeap = new MyHeap(10);
        maxHeap.add(10);
        maxHeap.add(4);
        maxHeap.add(9);
        maxHeap.add(1);
        maxHeap.add(7);
        maxHeap.add(5);
        maxHeap.add(3);

        System.out.println(maxHeap + " - myHeap add() & heapify()");

        maxHeap.remove(0);
        System.out.println(maxHeap + " - myHeap remove() & heapifyDown()");

        maxHeap.removeRoot();
        System.out.println(maxHeap + " - myHeap removeRoot()");
    }
}
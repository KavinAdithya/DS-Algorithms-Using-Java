package com.techcrack.dsa.recursion.sorting;

import java.util.Stack;

public class StackSort {
    public static void sortStack(Stack<Integer> elements) {
        if (elements.isEmpty()) {
            return;
        }

        int val = elements.pop();

        sortStack(elements);

        if (elements.isEmpty() || elements.peek() <= val) {
            elements.push(val);
        }
        else {
            int top = elements.pop();
            elements.push(val);
            elements.push(top);
        }
    }

    public static void sortIt(Stack<Integer> elements) {
        int size = elements.size();

        for (int i = 1; i < size; i++) {
            sortStack(elements);
        }
    }


    public static void stackSort(Stack<Integer> elements) {
        if (elements.isEmpty()) {
            return;
        }

        int top = elements.pop();
        stackSort(elements);
        insertSort(elements, top);
    }

    private static void insertSort(Stack<Integer> elements, int value) {
        if (elements.isEmpty() || elements.peek() <= value) {
            elements.push(value);
            return;
        }

        int top = elements.pop();
        insertSort(elements, value);
        elements.push(top);
    }


    public static void main(String[] args) {
        Stack<Integer> elements = new Stack<>();

        elements.push(-1);
        elements.push(3);
        elements.push(119);
        elements.push(2);
        elements.push(28);


        System.out.println(elements);
        stackSort(elements);
        System.out.println(elements);



    }
}

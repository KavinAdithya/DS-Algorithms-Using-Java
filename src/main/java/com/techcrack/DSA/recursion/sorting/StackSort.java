package com.techcrack.dsa.recursion.sorting;

import java.util.Arrays;
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

    public static void main(String[] args) {
        Stack<Integer> elements = new Stack<>();

        elements.push(-1);
        elements.push(3);
        elements.push(2);
        elements.push(28);
        elements.push(119);

        System.out.println(elements);
        sortIt(elements);
        System.out.println(elements);



    }
}

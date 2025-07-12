package com.techcrack.dsa.recursion.practise;

import java.util.Stack;

public class SortStack {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int topElement = stack.pop();
        sortStack(stack);

        put(stack, topElement);
    }

    public static void put(Stack<Integer> stack, int target) {
        if (stack.isEmpty() || target <= stack.peek()) {
            stack.push(target);
            return;
        }

        int topElement = stack.pop();

        put(stack, target);

        stack.push(topElement);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(32);
        stack.push(3);
        stack.push(41);

        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

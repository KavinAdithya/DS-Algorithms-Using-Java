package com.techcrack.dsa.tree;

import com.techcrack.dsa.arrayBinarySearch.PlusOne;

import javax.swing.*;

public class BST {
    public static Node root;

    public static class Node {
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void insert(int value) {
        root = insert(root, value);
    }

    public static Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            node.left = insert(node.left, value);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return node;
    }

    public static void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length - 1);
    }

    public static void populateSorted(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = start + (end - start) / 2;

        insert(nums[mid]);
        populateSorted(nums, start, mid - 1);
        populateSorted(nums, mid + 1, end);
    }

    public static int getHeight(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public static boolean isTreeBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1&&
                isTreeBalanced(node.left) &&
                isTreeBalanced(node.right);
    }

    public static void display(Node node, int level) {
        if (node == null) {
            return;
        }

        display(node.right, level + 1);

        if (level == 0) {
            System.out.println(node.value);
        } else {
            for (int i = 0; i < level - 1; ++i) {
                System.out.print("|\t\t");
            }

            System.out.println("|------->" + node.value);
        }

        display(node.left, level + 1);
    }

    public static void createSortedTree(int[] num) {
        int n = num.length;

        root = new Node(num[n / 2]);

        createSortedTree(root, num, 0, n / 2, n - 1);
    }

    public static void createSortedTree(Node node, int[] num, int start, int mid, int end) {
        if (node == null || start > end) {
            return;
        }

        int e1 = mid - 1;
        int s1 = mid + 1;

        int leftMid = start + (e1 - start) / 2;
        int rightMid = s1 + (end - s1) / 2;

        if (start != mid) {
            node.left = new Node(num[leftMid]);
            createSortedTree(node.left, num, start, leftMid, e1);
        }

        if (end != mid) {
            node.right = new Node(num[rightMid]);
            createSortedTree(node.right, num, s1, rightMid, end);
        }
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {

//        insert(1);
//        insert(2);
//        insert(-1);
//        insert(-2);

//        populateSorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        createSortedTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        display(root, 0);

//        preOrder(root);
//        System.out.println();
        inOrder(root);
        System.out.println();
//        postOrder(root);
//
//        System.out.println();

        System.out.println(isTreeBalanced(root));
    }
}

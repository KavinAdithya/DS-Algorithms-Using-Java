package com.techcrack.dsa.tree;

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

    public static int getHeight(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }
}

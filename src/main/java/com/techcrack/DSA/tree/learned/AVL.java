package com.techcrack.dsa.tree.learned;

public class AVL {
    private Node root;

    public static class Node {
        private final int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public int getHeight() {
        return getHeight(root);
    }

    public void display() {
        display(root, "");
    }

    public void display(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.value);
        display(node.right, "\t" + indent);
        display(node.left, "\t" + indent);
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        }

        if (value > node.value) {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;


        return rotate(node);
//        return node;
    }

    public Node rotate(Node node) {
        if (getHeight(node.left) - getHeight(node.right) > 1) {
            if (getHeight(node.left.left) - getHeight(node.left.right ) > 0) {
                return rightRotate(node);
            }

            if (getHeight(node.left.left) - getHeight(node.left.right) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (getHeight(node.left) - getHeight(node.right) < -1) {
            if (getHeight(node.right.left) - getHeight(node.right.right) < 0) {
                return leftRotate(node);
            }

            if (getHeight(node.right.left) - getHeight(node.right.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;

        return c;
    }

    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;

        return c;
    }

    public static void main(String[] args) {
        AVL tree = new AVL();

        for (int i = 1; i <= 10; ++i) {
            tree.insert(i);
        }

        tree.display();

        System.out.println(tree.getHeight());
    }
}

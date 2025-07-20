package com.techcrack.dsa.tree.practise;

import java.util.Scanner;

public class Tree {
    static Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void createTree(Node root, Scanner scan) {
        if (root == null) {
            return;
        }

        System.out.print("Do you Want to insert to left of root " + root.value + " : ");

        if (scan.nextBoolean()) {
            System.out.print("Enter the Left Value : ");
            root.left = new Node(scan.nextInt());
        }

        System.out.print("Do you Want to insert to right of root " + root.value + " : ");

        if (scan.nextBoolean()) {
            System.out.print("Enter the Right Value : ");
            root.right = new Node(scan.nextInt());
        }

        System.out.println();

        createTree(root.left, scan);
        createTree(root.right, scan);
    }

    public static void createTree(Scanner scan) {
        root = new Node(scan.nextInt());

        createTree(root, scan);
    }

    public static void display(Node root) {
        display(root, "");
    }

    public static void display(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.value);
        display(node.left, "\t" + indent);
        display(node.right, "\t" + indent);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        createTree(scan);
        display(root);
    }
}

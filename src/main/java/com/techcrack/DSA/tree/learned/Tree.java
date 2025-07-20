package com.techcrack.dsa.tree.learned;

import java.util.Scanner;

public class Tree {
    public static void createTree(TreeNode root, Scanner scanner) {
        System.out.print("Do you want to Insert to Left Of " + root.val + " ");
        boolean left = scanner.nextBoolean();

        if (left) {
            System.out.print("Enter the left value of root " + root.val + " ");
            int val = scanner.nextInt();
            var node = new TreeNode(val);
            root.left = node;
            createTree(node, scanner);
        }

        System.out.print("Do you want To insert to right of " + root.val + " ");

        boolean right = scanner.nextBoolean();

        if (right) {
            System.out.print("Enter the right value of root " + root.val + " ");
            int val = scanner.nextInt();
            var node = new TreeNode(val);
            root.right = node;
            createTree(node, scanner);
        }
    }

    public static void display(TreeNode node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.val);

        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public static void prettyDisplay(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        prettyDisplay(root.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; ++i) {
                System.out.print("\t\t");
            }

            System.out.println("|------->" + root.val);
        } else {
            System.out.println(root.val);
        }

        prettyDisplay(root.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the root Value : ");
        int val = scan.nextInt();
        var root = new TreeNode(val);

        createTree(root, scan);

//        display(root, "");

        prettyDisplay(root, 0);
    }
}

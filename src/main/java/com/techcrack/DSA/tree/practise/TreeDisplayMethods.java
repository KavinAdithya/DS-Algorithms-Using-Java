package com.techcrack.dsa.tree.practise;

import com.techcrack.dsa.tree.learned.TreeNode;

public class TreeDisplayMethods {
    public static void display(TreeNode node, int level) {
        if (node == null) return;

        display(node.right, level + 1);

        for (int i = 1; i < level; ++i) {
            System.out.print("|       ");
        }

        if (level == 0) System.out.println(node.val);
        else System.out.println("|-------" + node.val);

        display(node.left, level + 1);
    }

    public static void display(TreeNode node) {
        display(node, 0);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);

        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);

        head.right = new TreeNode(3);
        head.right.left  = new TreeNode(6);
        head.right.right = new TreeNode(7);

        display(head);
    }
}

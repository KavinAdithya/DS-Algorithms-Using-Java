package com.techcrack.dsa.tree.tuf.problems;

import com.techcrack.dsa.tree.learned.Tree;
import com.techcrack.dsa.tree.learned.TreeNode;

import java.util.Arrays;
import java.util.List;

public class FindSuccessorOrPredecessor {
    public static List<Integer> findPreSuc(TreeNode node, int prev, int key) {
        if (node == null) return Arrays.asList(prev, -1);

        if (node.val == key) {
            int left = node.left != null ? node.left.val : prev;
            int right = node.right != null ? node.right.val : -1;

            return List.of(left, right);
        }

        if (prev != -1 && prev <= key && key < node.val) {
            return List.of(prev, node.val);
        }

        if (node.val > key) {
            return findPreSuc(node.left, node.val, key);
        }

        return findPreSuc(node.right, node.val, key);
    }

    public static int findSuccessor(TreeNode node, Integer successor, int key) {
        if (node == null) return successor == null ? -1 : successor;

        if (node.val > key) {
            if (successor == null || successor > node.val) {
                successor = node.val;
            }

            return findSuccessor(node.left, successor, key);
        }

        return findSuccessor(node.right, successor, key);
    }

    public static int findSuccessorMono(TreeNode node, int key) {
        Integer successor = null;

        while (node != null) {
            if (node.val > key) {
                successor = node.val;
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return successor == null ? -1 : successor;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(10);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(12);

        System.out.println(findSuccessorMono(node, 12));
    }
}

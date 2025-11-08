package com.techcrack.dsa.tree.problems;

import com.techcrack.dsa.tree.learned.Tree;

import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BoundaryClassification {
     static class TreeNode {
        int data;
        TreeNode left, right;
    }

    public BoundaryClassification(int value) {
         if (value < 0) {
             System.out.println("Invalid Data...");
             return;
         }

        System.out.println("Valid Data");
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void addLeaves(TreeNode node, List<Integer> ans) {
         if (node == null) {
             return;
         }

         if (isLeaf(node)) {
             ans.add(node.data);
             return;
         }

         addLeaves(node.left, ans);
         addLeaves(node.right, ans);
    }

    public static void leftBoundary(TreeNode node, List<Integer> ans) {
         while (node != null && !isLeaf(node)) {
             ans.add(node.data);

             if (node.left != null) {
                 node = node.left;
             }
             else {
                 node = node.right;
             }
         }
    }

    public static void rightBoundary(TreeNode node, List<Integer> ans) {
         Deque<Integer> stack = new ArrayDeque<>();

         while (node != null && !isLeaf(node)) {
             stack.push(node.data);

             if (node.right != null) {
                 node = node.right;
             }
             else {
                 node = node.left;
             }
         }

         while (!stack.isEmpty()) {
             ans.add(stack.pop());
         }
    }

    public static List<Integer> boundary(TreeNode node) {
         List<Integer> ans = new ArrayList<>();

         if (node == null) {
             return ans;
         }

         ans.add(node.data);

         leftBoundary(node.left, ans);
         addLeaves(node, ans);
         rightBoundary(node.right, ans);

         return ans;
    }

    static public int getNum() {
         return 1;
    }

}
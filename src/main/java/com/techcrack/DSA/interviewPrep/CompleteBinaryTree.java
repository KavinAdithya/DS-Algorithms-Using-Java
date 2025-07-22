package com.techcrack.dsa.interviewPrep;


import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}

public class CompleteBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        int treeHeight = getHeight(root);

        if (treeHeight == 0) {
            return false;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        int level = 1;

        queue.offer(root);
        root.val = 1;

        while (! queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; ++i) {
                TreeNode curNode = queue.poll();

                int val = (curNode.val - 1) * 2;
                TreeNode left = curNode.left;
                TreeNode right = curNode.right;

                if (left != null) {
                    left.val = val + 1;
                    queue.offer(left);
                }

                if (right != null) {
                    right.val = val + 2;
                    queue.offer(right);
                }
            }

            int ele = (int)Math.pow(2, level);

            if (ele != queue.size()) {
                break;
            }

            level++;
        }

        if (queue.isEmpty()) {
            return true;
        }

        int prev = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll().val;

            if (cur - prev > 1) {
                return false;
            }

            prev = cur;
        }

        return treeHeight == level + 1;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void count2sOccur(boolean isUsed, int n, int end, int[] count) {
        if (isUsed && n <= end) {
            System.out.println(n);
            count[0]++;
        }

        if (n > end) {
            return;
        }

        for (int i = (n == 0 ? 1 : 0); i < 10; ++i) {
            count2sOccur(isUsed || i == 2, n * 10 + i, end, count);
        }
    }

    public static void main(String[] args) {
        int[] count = {0};
        count2sOccur(false, 0, 100, count);
        System.out.println(count[0]);
    }
}
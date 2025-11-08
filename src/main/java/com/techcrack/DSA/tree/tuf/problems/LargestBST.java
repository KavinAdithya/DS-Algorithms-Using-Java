package com.techcrack.dsa.tree.tuf.problems;

import com.techcrack.dsa.tree.learned.TreeNode;


class LargestBST {
    static class Pair {
        int count;
        int min;
        int max;

        public Pair(int count, int min, int max) {
            this.count = count;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBST(TreeNode root) {
        return countNodes(root).count;
    }

    public Pair countNodes(TreeNode node) {
        if (node == null) 
            return new Pair(0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Pair left = countNodes(node.left);
        Pair right = countNodes(node.right);

        if (left.max < node.val && node.val < right.min) {
            return new Pair(left.count + right.count + 1, Math.min(left.min, node.val),
            Math.max(right.max, node.val));
        }

        return new Pair(Math.max(left.count, right.count), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
}
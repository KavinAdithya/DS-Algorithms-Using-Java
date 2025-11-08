package com.techcrack.dsa.tree.practise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TreeVideoPractise {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPathExist(TreeNode node, int[] path, int idx) {

        if (idx == path.length) return true;

        if (node == null) return false;

        if (idx != 0) {
            if (node.val != path[idx]) return false;
        }

        if (path[idx] == node.val) idx++;

        return isPathExist(node.left, path, idx) ||
                isPathExist(node.right, path, idx);
    }

    public static void countPathExist(TreeNode node, Set<TreeNode> visited, int[] count, int sum, int target) {
        if (node == null) {
            return;
        }

        sum += node.val;

        if (sum == target) {
            count[0]++;
        }

        countPathExist(node.left, visited, count, sum, target);
        countPathExist(node.right, visited, count, sum, target);

        if (!visited.contains(node)) {
            countPathExist(node.left, visited, count, 0, target);
            countPathExist(node.right, visited, count, 0, target);
            visited.add(node);
        }
    }

    public static void countPathExist(TreeNode node, Map<Integer, Integer> prefixSum, int[] count, int sum, int target) {
        if (node == null) {
            return;
        }

        sum += node.val;

        if (prefixSum.containsKey(sum - target)) {
            count[0] += prefixSum.get(sum - target);
        }

        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0 ) + 1);

        countPathExist(node.left, prefixSum, count, sum, target);
        countPathExist(node.right, prefixSum, count, sum, target);

        prefixSum.put(sum, prefixSum.get(sum) - 1);
    }

    public static void main(String[] args) {
        var head = new TreeNode(1);
        head.left = new TreeNode(3);
        head.right = new TreeNode(2);
        head.right.left = new TreeNode(1);
        head.right.left.left = new TreeNode(11);
        head.right.right = new TreeNode(3);
        head.right.right.left = new TreeNode(2);
        head.right.right.left.right = new TreeNode(2);
        head.right.right.left.right.left = new TreeNode(16);

        int[] count = {0};

        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        countPathExist(head, map, count, 0, 4);

        System.out.println("Path exists are : " + count[0]);

    }
}

package com.techcrack.dsa.tree.tuf.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BottomView {
    public static class Pair {
        int val, level;

        public Pair(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    public List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Map<Integer, List<Pair>> map = new HashMap<>();
        int[] boundary = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        putNodes(root, map, boundary, 0, 0);

        for (int i = boundary[1]; i >= boundary[0]; --i) {
            int maxLevel = Integer.MIN_VALUE;
            int maxValue = 0;

            for (var val : map.get(i)) {
                if (val.level >= maxLevel)  {
                    maxLevel = val.level;
                    maxValue = val.val;
                }
            }

            ans.add(maxValue);
        }

        return ans;
    }

    public void putNodes(TreeNode node, Map<Integer, List<Pair>> map, int[] boundary, int val, int level) {
        if (node == null) return;

        var curList = map.getOrDefault(val, new ArrayList<>());
        var pair = new Pair(node.data, level);

        curList.add(pair);
        map.put(val, curList);

        boundary[0] = Math.min(val, boundary[0]);
        boundary[1] = Math.max(val, boundary[1]);

        putNodes(node.left, map, boundary, val + 1, level + 1);
        putNodes(node.right, map, boundary, val - 1, level + 1);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(20);

        head.left = new TreeNode(8);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(3);
        head.left.right.left = new TreeNode(10);
        head.left.right.right = new TreeNode(14);

        head.right = new TreeNode(22);
        head.right.right = new TreeNode(25);

        System.out.println(new BottomView().bottomView(head));
    }
}

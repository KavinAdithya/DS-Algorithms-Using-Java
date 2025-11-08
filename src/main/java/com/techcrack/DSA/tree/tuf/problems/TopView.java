package com.techcrack.dsa.tree.tuf.problems;

import java.util.*;

public class TopView {
//    private void traverseOneSide(TreeNode node, List<Integer> values, boolean isLeft) {
//        while (node != null) {
//            values.add(node.data);
//            node = isLeft ? node.left : node.right;
//        }
//    }
//
//    private void reverse(List<Integer> entity) {
//        int start = 0;
//        int end = entity.size() - 1;
//
//        while (start < end) {
//
//            int temp = entity.get(start);
//            entity.set(start, entity.get(end));
//            entity.set(end, temp);
//
//            start++;
//            end--;
//        }
//    }
//
//    public List<Integer> topView(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//
//        if (root == null) return ans;
//
//        ans.add(root.data);
//
//        traverseOneSide(root.left, ans, true);
//        reverse(ans);
//        traverseOneSide(root.right, ans, false);
//
//        return ans;
//    } // It Will miss some scenario

    public static class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> topView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair(root, 0));
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            var pair = queue.poll();
            var node = pair.node;
            var level = pair.level;

            min = Math.min(level, min);
            max = Math.max(level, max);

            if (! map.containsKey(level)) {
                map.put(level, node.data);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, level - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1));
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = min; i <= max; ++i) {
            ans.add(map.get(i));
        }

        return ans;
    }
}

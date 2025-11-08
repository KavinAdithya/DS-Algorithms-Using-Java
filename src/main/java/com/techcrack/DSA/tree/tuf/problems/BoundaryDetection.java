package com.techcrack.dsa.tree.tuf.problems;

import java.util.ArrayList;
import java.util.List;

public class BoundaryDetection {
    public static void AddLeftSubTree(TreeNode node, List<Integer> ans) {
        while (node != null) {
            ans.add(node.data);

            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    public static void addLeaves(TreeNode node, List<Integer> ans) {
        if (node == null) return;

        if (node.left == null && node.right == null) ans.add(node.data);

        addLeaves(node.left, ans);
        addLeaves(node.right, ans);
    }

    public static void addRightSubtree(TreeNode node, List<Integer> ans) {
        List<Integer> curAns = new ArrayList<>();

        while (node != null) {
            curAns.add(node.data);

            if (node.right != null) node = node.right;
            else node = node.left;
        }

        for (int i = curAns.size() - 1 ; i >= 0 ; i--) {
            ans.add(curAns.get(i));
        }
    }

}

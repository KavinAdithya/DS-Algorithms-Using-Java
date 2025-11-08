package com.techcrack.dsa.tree.tuf.problems;

import com.techcrack.dsa.tree.learned.TreeNode;

class ChildrenSumProperty {
    public int checkChildrenSum(TreeNode node) {
       return isSum(node) ? 1 : 0;
    }

    public boolean isSum(TreeNode node) {
         if (isEmptyOrLeaf(node)) return true;

        int leftVal = node.left == null ? 0 : node.left.val;
        int rightVal = node.right == null ? 0 : node.right.val;

        return leftVal + rightVal == node.val && isSum(node.left) && isSum(node.right);
    }

    public boolean isEmptyOrLeaf(TreeNode node) {
        return node == null || node.left == null && node.right == null;
    }
}

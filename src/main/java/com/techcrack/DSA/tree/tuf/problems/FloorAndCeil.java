package com.techcrack.dsa.tree.tuf.problems;

import com.techcrack.dsa.tree.learned.TreeNode;

import java.util.ArrayList;
import java.util.List;

class FloorAndCeil {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ans.add(-1);

        findFloorAndCeil(root, ans, key);
        return ans;
    }

    public void findFloorAndCeil(TreeNode node, List<Integer> ans, int key) {
        if (node == null) return;

        if (node.val == key) {
            ans.set(0, key);
            ans.set(1, key);
        } else if (node.val > key) {
            ans.set(1, node.val);
            findFloorAndCeil(node.left, ans, key);
        } else {
            ans.set(0, node.val);
            findFloorAndCeil(node.right, ans, key);
        }
    }
}
package com.techcrack;

import com.techcrack.dsa.tree.learned.TreeNode;

import java.util.ArrayList;
import java.util.List;

class FindAllPaths {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        //your code goes here

        List<List<Integer>> paths = new ArrayList<>();

        findAllPaths(paths, new ArrayList<>(), root);

        return paths;   
    }

    public void findAllPaths(List<List<Integer>> paths, List<Integer> curPath, TreeNode node) {
        if (node == null) {
            return;
        }

        curPath.add(node.val);

        if (isLeaf(node))
            paths.add(new ArrayList<>(curPath));
        else {
            findAllPaths(paths, curPath, node.left);
            findAllPaths(paths, curPath, node.right);
        }
        
        curPath.remove(curPath.size() - 1);
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
package com.techcrack.dsa.tree.tuf.problems;

import com.techcrack.dsa.tree.learned.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AllTraversals {
    public List<List<Integer>> treeTraversal(TreeNode root) {
        //your code goes here
        List<List<Integer>> traversals = Arrays.asList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        findAllTraversals(root, traversals);

        return traversals;
    }

    public void findAllTraversals(TreeNode node, List<List<Integer>> traversals) {
        if (node == null) return;

        traversals.get(1).add(node.data);

        findAllTraversals(node.left, traversals);

        traversals.get(0).add(node.data);

        findAllTraversals(node.right, traversals);

        traversals.get(2).add(node.data);
    }
    public static class Pair {
        public TreeNode node;
        public int num;

        public Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public void findTraversals(TreeNode node, List<List<Integer>> traversals) {
        if (node == null) return;

        var preorder = traversals.get(1);
        var inorder = traversals.get(0);
        var postorder = traversals.get(2);

        var stack = new Stack<Pair>();
        stack.push(new Pair(node, 1));

        while (! stack.isEmpty()) {
            var curPair = stack.peek();

            if (curPair.num == 1) {
                preorder.add(curPair.node.data);

                curPair.num++;

                if (curPair.node.left != null) {
                    stack.push(new Pair(curPair.node.left, 1));
                }
            } else if (curPair.num == 2) {
                inorder.add(curPair.node.data);

                curPair.num++;

                if (curPair.node.right != null) {
                    stack.push(new Pair(curPair.node.right, 2));
                }
            } else {
                postorder.add(stack.pop().node.data);
            }
        }
    }
}

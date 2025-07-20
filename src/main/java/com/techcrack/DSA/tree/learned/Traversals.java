package com.techcrack.dsa.tree.learned;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import com.techcrack.dsa.tree.learned.BST.Node;

public class Traversals {
    public static List<Integer> traverseByLevel(Node node) {
        List<Integer> ans = new ArrayList<>();

        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(node);

        while (! queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 1; i <= levelSize; ++i) {
                Node n = queue.poll();

                assert n != null;
                ans.add(n.value);

                if (n.left != null) {
                    queue.offer(n.left);
                }

                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
        }

        return ans;
    }

}

package com.techcrack.dsa.tree.learned;
import com.techcrack.dsa.tree.learned.BST.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class Questions {
    public static Node findSuccessor(Node root, Node target) {
        if (root == null) {
            return root;
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (! queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (node == target) {
                break;
            }
        }

        return queue.isEmpty() ? null : queue.peek();
    }
}

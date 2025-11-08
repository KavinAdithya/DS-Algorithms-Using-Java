package com.techcrack.dsa.tree.tuf.problems;

public class TreeToList {
    public static class Boundary {
        public Node head, tail;

        public Boundary(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static class Node {
        public int val;
        public Node left, right, next, prev;

        public Node(int val) {
            this.val = val;
        }
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static Boundary createList(Node node) {
        if (node == null) return null;

        if (isLeaf(node)) return new Boundary(node, node);

        var left = createList(node.left);
        var right = createList(node.right);

        if (right == null)  {
            left.tail.next = node;
            node.prev = left.tail;

            return new Boundary(left.head, node);
        } else if (left == null) {
            node.next = right.head;
            right.head.prev = node;

            return new Boundary(node, right.tail);
        } else {
            left.tail.next = node;
            node.prev = left.tail;

            node.next = right.head;
            right.head.prev = node;

            return new Boundary(left.head, right.tail);
        }
    }

    public static void traverseList(Boundary boundary) {
        var cur = boundary.tail;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.prev;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(30);

        head.left = new Node(20);
        head.left.left = new Node(10);
        head.left.left.left = new Node(5);

        head.left.left.right = new Node(15);
        head.left.right = new Node(25);
        head.left.right.left = new Node(23);
        head.left.right.right = new Node(27);

        head.right = new Node(40);
        head.right.left = new Node(35);
        head.right.left.left = new Node(33);

        head.right.left.right = new Node(38);
        head.right.right = new Node(45);
        head.right.right.left = new Node(43);
        head.right.right.right = new Node(53);

        var boundary = createList(head);

        traverseList(boundary);

    }
}

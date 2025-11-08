package com.techcrack.dsa.tree.tuf.problems;

public class UniqueTree {
    public boolean uniqueBinaryTree(int a, int b) {
        return (a == 2 || b == 2) && a != b;
    }
}

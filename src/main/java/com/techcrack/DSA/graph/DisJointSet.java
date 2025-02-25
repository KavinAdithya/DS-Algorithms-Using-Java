package com.techcrack.dsa.graph;

public class DisJointSet {
    private final int[] rank;
    private final int[] parent;
    private final int[] size;

    public DisJointSet(int n) {
        rank = new int[n + 1];

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int getParent(int node) {
        if (node == parent[node]) return node;
        return getParent(parent[node]);
    }

    public void unionByRank(int u, int v) {
        int uParent = getParent(u);
        int vParent = getParent(v);

        if (uParent == vParent) return;

        if (rank[uParent] < rank[vParent])
            parent[uParent] = vParent;
        else if (rank[vParent] < rank[uParent])
            parent[vParent] = vParent;
        else {
            parent[vParent] = uParent;
            rank[uParent] += 1;
        }
    }

    public void unionBySize(int u, int v) {
        int uParent = getParent(u);
        int vParent = getParent(v);

        if (uParent == vParent) return;

        if (size[uParent] < size[vParent]) {
            parent[uParent] = parent[vParent];
            size[vParent] += size[uParent];
        }
        else if (size[vParent] < size[uParent]) {
            parent[vParent] = parent[uParent];
            size[uParent] += size[vParent];
        }
        else {
            parent[vParent] = parent[uParent];
            size[uParent] += size[vParent];
        }
    }

    public static void main(String[] args) {
        DisJointSet ds = new DisJointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.getParent(3) == ds.getParent(7)) {
            System.out.println("Belongs to same component...");
        }
        else {
            System.out.println("Belongs to different component...");
        }

        ds.unionByRank(3, 7);
        if (ds.getParent(3) == ds.getParent(7))
            System.out.println("Belongs to same component...");
        else
            System.out.println("Belongs to different component...");
    }
}

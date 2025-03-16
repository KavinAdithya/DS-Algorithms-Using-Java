package com.techcrack.dsa.revisit;

public class Union {
    private final int[] rank;
    private final int[] size;
    private final int[] parent;

    public Union(int n) {
        rank = new int[n];
        size = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void unionBySize(int u, int v) {
        int uParent = getParent(u);
        int vParent = getParent(v);

        if (uParent == vParent)
            return;

        if (size[uParent] > size[vParent]) {
            parent[vParent] = uParent;
            size[uParent] = size[vParent];
        }
        else {
            parent[uParent] = vParent;
            size[vParent] = size[uParent];
        }
    }

    public void unionByRank(int u, int v) {
        int uParent = getParent(u);
        int vParent = getParent(v);

        if (uParent == vParent) return;

        if (rank[uParent] > rank[vParent])
            parent[vParent] = uParent;
        else if (rank[uParent] < rank[vParent])
            parent[uParent] = vParent;
        else {
            parent[uParent] = vParent;
            rank[vParent]++;
        }
    }

    public int getParent(int u) {
        if (u == parent[u]) return u;

        return parent[u] = getParent(parent[u]);
    }

    public static void main(String[] args) {
        Union union = new Union(6);

//        union.unionByRank(4, 1);
//        union.unionByRank(3, 1);
//        union.unionByRank(4, 2);

        union.unionBySize(4, 1);
        union.unionBySize(3, 1);
        union.unionBySize(4, 2);


        for (int i = 0; i < 6; i++) {
            System.out.println("Node " + i + " Parent is " + union.getParent(i));

        }
    }
}

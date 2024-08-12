package com.techcrack.DSA.WeeklyContest.Week410;

import java.util.*;

class GoodNodes {
    private List<List<Integer>> graph;
    private boolean[] visited;
    private int[] childCount;

    public int countGoodNodes(int[][] edges) {
        int length = edges.length + 1;

        graph = new ArrayList<>(length);

        visited = new boolean[length];
        childCount = new int[length];

        for (int i = 0; i < length; i++)
            graph.add(new ArrayList<Integer>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }       

        dfs(0);

        System.out.println(Arrays.toString(childCount));

        return goodNodes(length);
    }


    public int dfs(int node) {
        visited[node] = true;
        int size = 1;

        for (int child : graph.get(node)) {
            if (!visited[child]) 
                size += dfs(child);
        }

        childCount[node] = size;

        return size;
    }

    public int goodNodes(int length) {
        int goodNodes = 0;

        for (int i = 0; i < length; i++) {
            boolean isGood = true;
            int previousNode = -1;

            for (int child : graph.get(i)) {
                if (childCount[i] > childCount[child]) {
                    if (previousNode == -1)
                        previousNode = childCount[child];
                    else if (previousNode != childCount[child]) {
                        isGood = false;
                        break;
                    }
                }
                
            }

            if (isGood)
                goodNodes++;
        }

        return goodNodes;
    }
}
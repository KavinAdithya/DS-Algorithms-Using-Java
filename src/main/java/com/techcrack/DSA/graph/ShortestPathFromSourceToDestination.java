package com.techcrack.dsa.graph;

import java.util.*;

public class ShortestPathFromSourceToDestination {
    static List<Integer> shortestPath(int[][] edges , int V, int S, int D) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] isVisited = new boolean[V];
        int[] parent = new int[V];
        parent[S] = -1;
        isVisited[S] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(S);

        while (! queue.isEmpty()) {
            int node = queue.poll();

            if (node == D) break;

            for (Integer ad : adjList.get(node)) {
                if (!isVisited[ad]) {
                    isVisited[ad] = true;
                    parent[ad] = node;
                    queue.add(ad);
                }
            }
        }

        if (! isVisited[D]) return null;

        List<Integer> path = new ArrayList<>();

        for (int cur = D; cur != -1; cur = parent[cur]) {
            path.add(cur);
        }

        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        int V = 8;
        int[][] edges = {
                {0, 1}, {1, 2}, {0, 3}, {3, 4}, {4, 7},
                {3, 7}, {6, 7}, {4, 5}, {4, 6}, {5, 6}
        };

        // Example 1: S = 0, D = 7 (Expected: 0 -> 3 -> 7)
        int S1 = 0, D1 = 7;
        List<Integer> path1 = shortestPath(edges, V, S1, D1);
        System.out.println("Shortest path from " + S1 + " to " + D1 + ": " + path1);

        // Example 2: S = 2, D = 6 (Expected: 2 -> 1 -> 0 -> 3 -> 4 -> 6)
        int S2 = 2, D2 = 6;
        List<Integer> path2 = shortestPath(edges, V,  S2, D2);
        System.out.println("Shortest path from " + S2 + " to " + D2 + ": " + path2);

//        Shortest path from 0 to 7: [0, 3, 7]
//        Shortest path from 2 to 6: [2, 1, 0, 3, 4, 6]
    }
}

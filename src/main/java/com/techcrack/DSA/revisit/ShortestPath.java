package com.techcrack.dsa.revisit;

import java.util.*;

public class ShortestPath {
    public static String findShortestPath(List<List<Integer>> adj, int src, int des) {
        int V = adj.size();

        int[] parent = new int[V];

        Arrays.fill(parent, -1);
        parent[src] = src;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(src);

        outer : while (! queue.isEmpty()) {
                int node = queue.poll();

                for (Integer ad : adj.get(node)) {
                    if (parent[ad] == -1) {
                        queue.offer(ad);
                        parent[ad] = node;

                        if (ad == des)
                            break outer;
                    }
                }
            }

        StringBuilder path = new StringBuilder();

        int node = des;

        while (node != parent[node]) {
            path.insert(0, " -> " + node);
            node = parent[node];
        }

        path.insert(0, node);

        return path.toString();
    }

    public static void main(String[] args) {
        // no. of vertices
        int V = 8;
        // Source and Destination vertex
        int S = 0, D = 7;
        // Edge list
        List<List<Integer> > edges = Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2),
                Arrays.asList(0, 3), Arrays.asList(3, 4),
                Arrays.asList(4, 7), Arrays.asList(3, 7),
                Arrays.asList(6, 7), Arrays.asList(4, 5),
                Arrays.asList(4, 6), Arrays.asList(5, 6));

        // List to store the graph as an adjacency list
        List<List<Integer> > graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        System.out.println(findShortestPath(graph, S, D));
    }
}

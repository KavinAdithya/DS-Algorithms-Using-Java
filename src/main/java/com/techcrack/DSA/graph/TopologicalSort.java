package com.techcrack.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    private static void topologicalSort(List<List<Integer>> adjList) {
        Stack<Integer> stack = new Stack<>();

        int n = adjList.size();
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (! isVisited[i]) {
                isVisited[i] = true;
                dfs(adjList, isVisited, stack, i);
                stack.push(i);
            }
        }

        while (! stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void dfs(List<List<Integer>> adjList, boolean[] isVisited, Stack<Integer> stack, int node) {
        for (Integer ad : adjList.get(node)) {
            if (! isVisited[ad]) {
                isVisited[ad] = true;
                dfs(adjList, isVisited, stack, ad);
                stack.push(ad);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        topologicalSort(adj);
    }
}

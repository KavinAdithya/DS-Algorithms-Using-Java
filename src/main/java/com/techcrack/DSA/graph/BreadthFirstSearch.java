package com.techcrack.dsa.graph;

import java.util.*;

public class BreadthFirstSearch {
    static void bfsIterative(List<List<Integer>> adjList, int startNode, int verCount) {
        boolean[] isVisited = new boolean[verCount];

        Queue<Integer> level = new ArrayDeque<>();
        isVisited[startNode] = true;
        level.add(startNode);

        while (! level.isEmpty()) {
            int top = level.poll();

            List<Integer> adjacent = adjList.get(top);

            for (Integer ad : adjacent) {
                if (isVisited[ad])
                    continue;

                isVisited[ad] = true;
                level.add(ad);
            }

            System.out.print(top + " ");
        }
    }

    private static void bfsRecur(List<List<Integer>> adjMat, List<Integer> curLevel, boolean[] isVisited) {
        if (curLevel.isEmpty()) return;

        List<Integer> nextLevel = new ArrayList<>();

        for (Integer level : curLevel) {
            for (Integer ad : adjMat.get(level)) {
                if (isVisited[ad]) continue;

                nextLevel.add(ad);
                isVisited[ad] = true;
            }

            System.out.print(level + " ");
        }

        bfsRecur(adjMat, nextLevel, isVisited);
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();


        adjList.add(new ArrayList<>());
        adjList.add(Arrays.asList(2, 3));
        adjList.add(Arrays.asList(1, 4, 5, 6));
        adjList.add(Arrays.asList(1, 7, 8, 9));
        adjList.add(List.of(2));
        adjList.add(List.of(2));
        adjList.add(Arrays.asList(2, 10));
        adjList.add(Arrays.asList(3, 10));
        adjList.add(List.of(3));
        adjList.add(List.of(3));
        adjList.add(Arrays.asList(6, 7));

        bfsIterative(adjList, 10, 11);
        System.out.println();
        boolean[] isVisited = new boolean[11];
        isVisited[10] = true;

        bfsRecur(adjList, List.of(10), isVisited);
    }
}

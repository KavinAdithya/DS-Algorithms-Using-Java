package com.techcrack.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    private static void dfsRecur(List<List<Integer>> adjMat, boolean[] isVisited, int curNode) {
        System.out.print(curNode + " ");

        for (Integer ad : adjMat.get(curNode)) {
            if (isVisited[ad]) continue;

            isVisited[ad] = true;
            dfsRecur(adjMat, isVisited, ad);
        }

    }


    private static void dfsIterate(List<List<Integer>> adjMat, int vertex, int startNode) {
        boolean[] isVisited = new boolean[vertex];

        Stack<Integer> nodes = new Stack<>();
        nodes.push(startNode);

        isVisited[startNode] = true;

        while (! nodes.isEmpty()) {
            int top = nodes.pop();

            for (Integer ad : adjMat.get(top)) {
                if (isVisited[ad]) continue;

                nodes.add(ad);
                isVisited[ad] = true;
            }

            System.out.print(top + " ");
        }

//        System.out.println(top);
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

        boolean[] isVisited = new boolean[11];
        isVisited[1] = true;

//        dfsRecur(adjList, isVisited, 1);
        dfsIterate(adjList, 11,  1);
    }
}
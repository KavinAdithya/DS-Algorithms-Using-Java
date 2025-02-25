package com.techcrack.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NodesRepresentation {
    private final static Scanner scan = new Scanner(System.in);

    private static boolean[][] matNode(int n) {
        boolean[][] nodes = new boolean[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            nodes[from][to] = true;
            nodes[to][from] = true;
        }

        return nodes;
    }

    private static List<List<Integer>> listNode(int n) {
        var nodes = new ArrayList<List<Integer>>(n + 1);

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i <= n; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            nodes.get(from).add(to);
            nodes.get(to).add(from);
        }

        return nodes;
    }

    public static void main(String[] args) {
        int n = scan.nextInt();

        for (boolean[] row : matNode(n)) {
            System.out.println(Arrays.toString(row));
        }

        for (List<Integer> row : listNode(n)) {
            System.out.println(row);
        }
    }
}

package com.techcrack.dsa.graph;

public class GraphAndVertices {
    static int countGraph(int n) {
        return (int) Math.pow(2, (double) (n * (n - 1)) / 2);
    }

    static long pow(int base, int pow) {
        return 1L << pow;
    }

    public static void main(String[] args) {
//        System.out.println(countGraph(5));

        System.out.println(pow(2, 46));
    }
}

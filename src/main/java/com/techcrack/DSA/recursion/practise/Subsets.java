package com.techcrack.dsa.recursion.practise;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private static final int[][] DIRECTIONS = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private static final char[] MOVE = {
            'D', 'R', 'T', 'L'
    };

    public static void subsets(int[] arr, List<Integer> processed, int index) {
        if (index == arr.length) {
            System.out.println(processed);
            return;
        }

        processed.add(arr[index]);
        subsets(arr, processed, index + 1);
        processed.remove(processed.size() - 1);

        subsets(arr, processed, index + 1);
    }

    private static List<List<Integer>> subsetsIterate(int[] arr) {
        int n = arr.length;

        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        for (int k : arr) {
            int end = subsets.size();

            for (int j = 0; j < end; j++) {
                List<Integer> cur = new ArrayList<>(subsets.get(j));
                cur.add(k);

                subsets.add(cur);
            }
        }

        return subsets;
    }

    private static void permutationString(String processed, String unprocessed, int index) {
        if (index == unprocessed.length()) {
            System.out.println(processed);
            return;
        }

        int end = processed.length() + 1;

        for (int i = 0; i < end; ++i) {
            String np = processed.substring(0, i) + unprocessed.charAt(index) + processed.substring(i);
            permutationString(np, unprocessed, index + 1);
        }
    }

    private static void permutation(int[] arr, List<Integer> permut, boolean[] isUsed, int index) {
        if (index == arr.length) {
            System.out.println(permut);
            return;
        }

        for (int i = 1; i <= arr.length; ++i) {
            if (! isUsed[i]) {
                isUsed[i] = true;
                permut.add(i);
                permutation(arr, permut, isUsed, index + 1);
                permut.remove(permut.size() - 1);
                isUsed[i] = false;
            }
        }
    }

    private static void maze(String path, int n, int r, int c) {
        if (r + 1 == n && c + 1 == n) {
            System.out.println(path);
        }

        if (c + 1 < n) {
            maze(path + 'H', n, r, c + 1);
        }
        if (r + 1 < n) {
            maze(path + 'V', n , r + 1, c);
        }
        if (c + 1 < n && r + 1 < n) {
            maze(path + 'D', n , r + 1, c + 1);
        }
    }

    private static void findAllPath(boolean[][] isUsed, String path, int n, int r, int c) {
        if (r + 1 == n && c + 1 == n) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < 4; ++i) {
            int r1 = r + DIRECTIONS[i][0];
            int c1 = c + DIRECTIONS[i][1];

            if (r1 >= 0 && r1 < n && c1 >= 0 && c1 < n && !isUsed[r1][c1])  {
                isUsed[r1][c1] = true;
                findAllPath(isUsed, path + MOVE[i], n, r1, c1);
                isUsed[r1][c1] = false;
            }
        }
    }

    private static void printBoard(boolean[][] isPlaced) {
        for (boolean[] placed : isPlaced) {
            for (boolean p : placed) {
                System.out.println(p ? "Q " : "X ");
            }
        }
    }

//    private static

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

//        subsets(arr, new ArrayList<>(), 0);


//        System.out.println(subsetsIterate(arr));

//        permutation(arr, new ArrayList<>(), new boolean[arr.length + 1], 0);

//        permutationString("", "abc", 0);

//        maze("", 3, 0, 0);

        findAllPath(new boolean[4][4], "", 4, 0, 0);
    }
}

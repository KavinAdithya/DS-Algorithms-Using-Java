package com.techcrack.dsa.recursion.backtrack.maze;

import java.util.*;

public class Main {
    static List<List<Integer>> paths = new ArrayList<>();
    public static int kFactorization(List<Integer> arr, List<Integer> ansPath, int target, int ans) {
        if (ans == target) {
            ansPath.add(ans);
           
            paths.add(new ArrayList<>(ansPath));

            ansPath.remove(ansPath.size() - 1);
            return 1;
        }
       
        if (ans > target) {
            return -1;
        }
       
        int step = Integer.MAX_VALUE;
       
        for (int i = 0; i < arr.size(); ++i) {
            ansPath.add(ans);
            int steps = kFactorization(arr, ansPath, target, ans * arr.get(i));

            if (steps != -1) {
                step = Math.min(steps + 1, step);
            }
           
            ansPath.remove(ansPath.size() - 1);
        }
       
        return step == Integer.MAX_VALUE ? -1 : step;
    }
   
    public static void main(String[] args) {
       List<Integer> arr = Arrays.asList(2, 4, 6, 9, 3, 7, 16, 10, 5);
        arr.sort(null);

       List<Integer> ans = new ArrayList<>();

//        int step = kFactorization(arr, ans, 72, 1);
//
//        if (step == -1) {
//            System.out.println(-1);
//            return;
//        }
//
//        for (List<Integer> a : paths) {
//
//            if (a.size() == step) {
//                System.out.println(a);
//                break;
//            }
//        }

        System.out.println(kFactorizationMemo(arr, new ArrayList<>(), 72, 1));
    }


    public static List<Integer> kFactorizationMemo(List<Integer> arr, List<Integer> ansPath, int target, int ans) {
        if (ans == target) {
            return List.of(ans);
        }

        if (ans > target) {
            return List.of(-1);
        }

        List<Integer> minPath = null;

        for (int i = 0; i < arr.size(); ++i) {
//            ansPath.add(ans);
            List<Integer> curPath = kFactorizationMemo(arr, ansPath, target, ans * arr.get(i));

            if (minPath == null || curPath.size() + 1 < minPath.size() && curPath.get(0) != -1) {
                minPath  = new ArrayList<>(curPath);
                minPath.add(0, ans);
            }

//            ansPath.remove(ansPath.size() - 1);
        }

        return minPath != null ? minPath : List.of(-1);
    }
}
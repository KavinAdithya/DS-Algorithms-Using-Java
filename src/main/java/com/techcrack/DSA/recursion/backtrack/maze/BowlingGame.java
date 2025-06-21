package com.techcrack.dsa.recursion.backtrack.maze;

import java.util.*;

public class BowlingGame {

    static int[] grundy;

    // Precompute Grundy numbers for segment lengths
    static void precomputeGrundy(int maxLen) {
        grundy = new int[maxLen + 1];
        for (int len = 1; len <= maxLen; len++) {
            Set<Integer> mex = new HashSet<>();

            // Remove single pin at position i
            for (int i = 0; i < len; i++) {
                int left = i;
                int right = len - i - 1;
                mex.add(grundy[left] ^ grundy[right]);
            }

            // Remove two adjacent pins at positions i and i+1
            for (int i = 0; i < len - 1; i++) {
                int left = i;
                int right = len - i - 2;
                mex.add(grundy[left] ^ grundy[right]);
            }

            // Find smallest non-negative integer not in mex
            int g = 0;
            while (mex.contains(g)) g++;
            grundy[len] = g;
        }
    }

    public static String isWinning(int n, String config) {
        List<Integer> segments = new ArrayList<>();
        int count = 0;
        for (char c : config.toCharArray()) {
            if (c == 'I') {
                count++;
            } else {
                if (count > 0) {
                    segments.add(count);
                    count = 0;
                }
            }
        }
        if (count > 0) segments.add(count);

        int xor = 0;
        for (int seg : segments) {
            xor ^= grundy[seg];
        }

        return xor != 0 ? "WIN" : "LOSE";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        precomputeGrundy(100); // Max pin segment

        while (t-- > 0) {
            int n = sc.nextInt();
            String config = sc.next();
            System.out.println(isWinning(n, config));
        }
    }
}

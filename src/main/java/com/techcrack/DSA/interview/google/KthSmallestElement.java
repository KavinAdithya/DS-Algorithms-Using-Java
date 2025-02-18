package com.techcrack.dsa.interview.google;

import java.lang.reflect.Array;
import java.util.Arrays;

public class KthSmallestElement {
    public static int kthBrute(int[][] mat, int k) {
        if (mat == null || mat.length != mat[0].length || k < 1)
            return -1;

        int n = mat.length;

        if (k > n * n)
            return -1;

        int[] copyMat1D = new int[n * n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(mat[i], 0, copyMat1D, i * n, n);
        }

        Arrays.sort(copyMat1D);

        return copyMat1D[k - 1];
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        System.out.println(kthBrute(mat, 10));
    }
}

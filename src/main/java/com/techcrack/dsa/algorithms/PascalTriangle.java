package com.techcrack.dsa.algorithms;

import java.util.Arrays;

public class PascalTriangle {
    static int rCc(int row, int col) {
        if (row < 0 || col < 0)
            return 0;

        row -= 1;

        int ans = 1;

        for (int i = 0; i < col; i++) {
            ans *= (row  - i);
            ans /= (i + 1);
        }

        return ans;
    }

    static int[] nCrow(int row) {
        if (row <= 0)
            return null;

        int[] rowArr = new int[row];

        rowArr[0]  = 1;
        rowArr[row - 1] = 1;

        for (int i = 1; i < row; i++) {
            rowArr[i] = rowArr[i - 1] * (row - i);
            rowArr[i] /= i;
        }

        return rowArr;
    }

    public static void main(String[] args) {
//        System.out.println(rCc(-1, -1));

        System.out.println(Arrays.toString(nCrow(10)));
    }
}

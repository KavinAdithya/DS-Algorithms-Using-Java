package com.techcrack.dsa.sorting;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

class MatrixCellsDistance {
    public int[][] allCellsDistOrder1(int rows, int cols, int rCenter, int cCenter) {
        int[][] matrix = new int[rows * cols][3];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = (i * cols) + j;

                matrix[index][0] = i;
                matrix[index][1] = j;
                matrix[index][2] = Math.abs(rCenter - i) + Math.abs(cCenter - j);
            }
        }

        Arrays.sort(matrix, (Comparator.comparingInt(a -> a[2])));

        int[][] result = new int[rows * cols][2];
        int i = 0;
        
        for (int[] mat : matrix) {
            result[i][0] = mat[0];
            result[i][1] = mat[1];
            i++;
        }

        return result;
    }

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][];
        boolean[][] isVisited = new boolean[rows][cols];
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new ArrayDeque<>();
        int i = 0;

        queue.add(new int[]{rCenter, cCenter});
        isVisited[rCenter][cCenter] = true;

        while (! queue.isEmpty()) {
            int r = queue.peek()[0];
            int c = queue.poll()[1];

            result[i] = new int[]{r, c};

            for (int[] dir : direction) {
                int r1 = r + dir[0];
                int c1 = c + dir[1];

                if (r1 < 0 || r1 >= rows || c1 < 0 || c1 >= cols || isVisited[r1][c1])
                    continue;

                queue.add(new int[]{r1, c1});
                isVisited[r1][c1] = true;
            }
            i++;
        }

        return result;
    }
}
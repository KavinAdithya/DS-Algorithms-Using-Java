package com.techcrack.dsa.recursion.backtrack.maze;

import java.util.*;

public class NQueenOptimized {
    public static int totalNQueens(int n) {
        return solve(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    public static int solve(int row, int n, Set<Integer> cols, Set<Integer> diag, Set<Integer> antiDiag) {
        if (row == n) return 1;

        int count = 0;

        for (int col = 0; col < n; col++) {
            int d = row - col;
            int ad = row + col;

            if (cols.contains(col) || diag.contains(d) || antiDiag.contains(ad))
                continue;

            cols.add(col);
            diag.add(d);
            antiDiag.add(ad);

            count += solve(row + 1, n, cols, diag, antiDiag);

            // Backtrack
            cols.remove(col);
            diag.remove(d);
            antiDiag.remove(ad);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

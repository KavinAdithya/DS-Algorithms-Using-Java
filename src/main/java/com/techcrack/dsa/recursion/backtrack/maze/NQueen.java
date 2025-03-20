package com.techcrack.dsa.recursion.backtrack.maze;
import static java.lang.System.out;
import java.util.Arrays;

public class NQueen {
    private static int queen;

    static int nQueen(boolean[] isColPossible, char[][] table, int row, int col) {
        if (row == table.length) {
            printTable(table);
            out.println();
            queen++;
            return 1;
        }

        int count = 0;

        for (int i = 0; i < table.length; i++) {
            if (row != 0 && (! isColPossible[i] || (i >= col - 1 && i <= col + 1)))
                continue;

            isColPossible[i] = false;
            table[row][i] = 'Q';

            count += nQueen(isColPossible, table, row + 1, i);

            isColPossible[i] = true;
            table[row][i] = 'X';
        }

        return count;
    }

    static void printTable(char[][] table) {
        for (char[] t : table)  {
            System.out.println(Arrays.toString(t));
        }
    }

    static void fillTable(char[][] table, char fill) {
        for (char[] t : table) {
            Arrays.fill(t, fill);
        }
    }

    static void fillColPossible(boolean[] isColPossible, boolean pos) {
        Arrays.fill(isColPossible, pos);
    }

    public static void main(String[] args) {
        int n = 3;
        char[][] table = new char[n][n];
        boolean[] isColPossible = new boolean[n];

        fillTable(table, 'X');
        fillColPossible(isColPossible, true);

        System.out.println(nQueen(isColPossible, table, 0, 0));

        out.println(queen);
    }
}

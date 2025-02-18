package com.techcrack.dsa.recursion.practise;

public class Pattern {
    static void downTriangle(int row, int col) {
        if (row == 0) return;

        if (row == col) {
            System.out.println();
            downTriangle(row - 1, 0);
        }
        else {
            System.out.print("* ");
            downTriangle(row, col + 1);
        }

    }

    static void upTriangle(int row, int col) {
        if (row == 0) return;

        if (row == col) {
            upTriangle(row - 1, 0);
            if (row != 1)
                System.out.println();
        }
        else {
            upTriangle(row, col + 1);
            System.out.print("* ");
        }


    }

    public static void main(String[] args) {
        upTriangle(4, 0);
    }
}

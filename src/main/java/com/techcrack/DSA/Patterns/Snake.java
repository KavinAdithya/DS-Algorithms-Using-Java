package com.techcrack.DSA.Patterns;

import java.util.Scanner;

public class Snake {

    static void top(int[][] arr, int row, int column, int end, int n) {
        for (int i = column; i <= end; i++)
            arr[row][i] = n++;
    }

    static void right(int[][] arr, int row, int column, int end, int n) {
        for (int i = row; i < end; i++)
            arr[i][column] = n++;
    }

    static void bottom(int[][] arr, int row, int column, int end,  int n) {
        for (int i = column; i > end; i--)
            arr[row][i] = n++;
    }

    static void left(int[][] arr, int row, int column, int end, int n) {
        for (int i = row; i > end; i--)
            arr[i][column] = n++;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] arr = new int[n][n];

        fillPattern(arr, n);
        printArray(arr, n);
    }

    static void fillPattern(int[][] arr, int n) {
        int top = 0;
        int right = n - 1;
        int m = 1;
        int i = n - 1;

        while (top <= right) {

            top(arr, top, top, right, m);
            m += i;
           
            right(arr, top, right, right, m);
            m += i;
             
            bottom(arr, right, right, top, m);
            m += i;

            left(arr, right, top, top, m);
            m += i;

             top++;
             right--;
             i -= 2;
        }
    }

    static void printArray(int[][] array, int n) {

        int length = String.valueOf(n).length();

        String[] space = new String[length];

        space[0] = " ";
        for (int i = length - 2; i > -1; i--)
            space[i] = space[i + 1] + " ";

        for (int[] arr : array) {

            for (int a : arr)
                System.out.print(space[String.valueOf(a).length() - 1] + " "+ a + " ");
            System.out.println();
        }
    }
}
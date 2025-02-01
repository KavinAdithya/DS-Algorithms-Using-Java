package com.techcrack.DSA.recursion.practise;

public class SumOfTriangle {
    static void printArr(int[] arr, int row) {
        if (row  == arr.length + 1) return;

        printArr(arr, row + 1);

        System.out.print("[");

        for (int i = 0; i < row; i++) {
            System.out.print(arr[i]);

            if (i + 1 != row)
                System.out.print(", ");
            if (i > 0)
                arr[i - 1] += arr[i];
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        printArr(arr, 1);
    }
}

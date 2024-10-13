package com.techcrack.DSA.Patterns;

public class SquarePattern {

    private static void squarePattern(int n) {
        int matrix = n * 2 ;

        for (int i = 1; i < n + 1; i++) {
            for (int j = n; j > n - i + 1; j--)
                System.out.print(j + " ");

            for (int j = 1; j < matrix -  (i + i - 2) ; j++)
                System.out.print(n - i + 1 + " ");

            for (int j = n -  i + 2; j < n + 1; j++)
                System.out.print(j + " ");


            System.out.println();
        }

        downSquare(n );

    }

    private static void downSquare(int n) {
        for (int i = 1; i < n ; i++) {
            for (int j = n; j > i + 1; j--)
                System.out.print(j + " ");

            for (int j = 1; j < (n * 2) - ((n - i - 1) * 2); j++)
                System.out.print(i + 1 + " ");

            for (int j =  i + 2; j < n + 1; j++)
                System.out.print(j + " ");

            System.out.println();
        }
    }


    public static void main(String[] args) {
        squarePattern(4);
    }
}

package com.techcrack.dsa.patterns.allPattern;

public class P17 {
    static void printSpace(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print(" ");
        }
    }

    static void printLeft(int n) {
        for (int i = n; i > 1; i--) {
            System.out.print(i);
        }
    }

    static void printRight(int n ) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i);
        }
        System.out.println();
    }

    static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            printSpace(n - i);
            printLeft(i);
            printRight(i);
        }

        for (int i = n - 1; i > 0; i--) {
            printSpace(n - i);
            printLeft(i);
            printRight(i);
        }
    }

    public static void main(String[] args) {
        printPattern(4);
    }
}

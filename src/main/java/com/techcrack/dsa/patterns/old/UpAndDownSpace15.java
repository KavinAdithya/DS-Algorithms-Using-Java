package com.techcrack.dsa.patterns;

public class UpAndDownSpace15 {
    static void upAndDownSpace(int length ) {
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length ; j++)
                System.out.print(" ");
            for (int k = 0; k < i + 1; k++) {
                if (k == 0 || k == i )
                    System.out.print("* ");
                else
                    System.out.print("  ");

            }

            System.out.println();
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < i + 2; j++)
                System.out.print(" ");
            for (int k = length - i - 1; k > 0 ; k--) {
                if (k == length  - i - 1 || k == 1 )
                    System.out.print("* ");
                else
                    System.out.print("  ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        upAndDownSpace(5);

    }

}

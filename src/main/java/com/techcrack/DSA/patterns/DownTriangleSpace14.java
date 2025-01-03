package com.techcrack.DSA.patterns;

public class DownTriangleSpace14 {

    static void downTriangleSpace(int length) {
        for (int i = 0; i < length * 2 + 1; i++)
            System.out.print("*");
        System.out.println();

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < i + 1; j++)
                System.out.print(" ");

            for (int k = length ; k > i; k--) {
                if (k == length || k  == i + 1 )
                    System.out.print("* " );
                else
                    System.out.print("  " );

            }

            System.out.println();
        }
    }

    public  static void main(String[] args) {
        downTriangleSpace(14);
    }
}

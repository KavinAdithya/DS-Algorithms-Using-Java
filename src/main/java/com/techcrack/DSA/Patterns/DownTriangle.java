package com.techcrack.DSA.Patterns;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class DownTriangle {

    static void downTriangle(int length) {
        int triangleShape = length % 2 == 0 ? length * 2 - 1 : length * 2 + 1;

        for (int i = triangleShape; i > 0; i -= 2) {
            for (int j = 1; j < (triangleShape - i + 1); j++)
                System.out.print(" ");

            for (int k = i; k > 0; k--)
                System.out.print("* ");
            System.out.println();

        }
    }

    public static void main(String[] args) {
        downTriangle(5);
    }
}

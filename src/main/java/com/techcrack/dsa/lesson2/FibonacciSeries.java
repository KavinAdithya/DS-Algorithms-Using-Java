package com.techcrack.dsa.lesson2;

import java.util.Scanner;
public class FibonacciSeries {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the N Number to Print Fibonacci Series : ");
        int n = scanner.nextInt();

        fiboPoly(n);
        System.out.println();
        expoFibo(n);

    }

    private static void fiboPoly(int n){
        int a = 0;
        int b = 1;

        System.out.print(a + " " + b + " ");

        for(; n > 1 ; n--){
            System.out.print(a  + b  +" ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    private static void expoFibo(int n){
        for(int k = 0; k < n + 1; k++)
            System.out.print(fibo(k) + " ");
    }

    private static int fibo(int n){
        if(n < 2)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }
}

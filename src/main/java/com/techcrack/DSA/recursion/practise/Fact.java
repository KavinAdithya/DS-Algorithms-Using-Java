package com.techcrack.DSA.recursion.practise;

public class Fact {
    static int fact(int n) {
        if (n <= 1)
            return 1;
        return n * fact(n - 1);
    }

    static int sum(int n) {
        if (n <= 1)
            return n;
        return n + sum(n - 1);
    }

    static int fibonacciConstant(int a, int b, int n) {
        if (n % 3 == 0) return a;
        if (n % 3 == 1) return b;

        return a ^ b;
    }

    static int fibo(int a, int b, int n)  {
        if (n == 0) return a;
        if (n == 1) return b;

        return fibo(a, b, n - 1) ^ fibo(a, b, n - 2);
    }

    static int countLength(String str) {
        if (str.isEmpty()) return 0;

        return 1 + countLength(str.substring(1));
    }

    public static void main(String[] args) {
//        System.out.println(fact(5));
//        System.out.println(sum(5));

        System.out.println(fibonacciConstant(4, 3, 4));
        System.out.println(fibo(4, 3, 4));
        System.out.println(countLength("Java "));
    }
}

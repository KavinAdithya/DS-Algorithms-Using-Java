package com.techcrack.DSA.recursion.practise;

public class Algorithm {

    static void print(int n) {
        System.out.println(n);

        String name = "Java Programming";

        if (n == 5)
            return;

        print(n + 1);
    }

    static int fibo(int n) {
        if (n < 2)
            return n;

        return fibo(n - 1) + fibo(n - 2);
    }
    public static void main(String[] args) {
        int n = 2;
//        print(n);

        System.out.println(fibo(3));
    }
}

package com.techcrack.DSA.recursion;

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

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(sum(5));
    }
}

package com.techcrack.dsa.recursion.practise;

public class reverseNumber {
    static int rev(int n) {
        int digits = (int) Math.log10(n) + 1 ;
        return helper(n, digits);
    }

    private static int helper(int n, int digit) {
        if (n % 10 == n)
            return n;

        return n % 10 * (int)Math.pow(10, digit - 1) + helper(n / 10, digit - 1);
    }

    public static void main(String[] args) {
        System.out.println(rev(1902));
    }
}

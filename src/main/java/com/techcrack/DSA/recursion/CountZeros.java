package com.techcrack.DSA.recursion;

public class CountZeros {

    static int countZeros(int n, int count) {
        if (n == 0)
            return count;
        count += (n % 10 == 0 ? 1 : 0);
        return countZeros(n / 10, count);
    }

    public static void main(String[] args) {
        System.out.println(countZeros(10000, 0));
    }
}

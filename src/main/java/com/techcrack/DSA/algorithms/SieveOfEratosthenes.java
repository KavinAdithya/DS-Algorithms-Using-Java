package com.techcrack.DSA.algorithms;

// import java.util.Arrays;

public class SieveOfEratosthenes {
    static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n];

        isPrime[0] = true;
        isPrime[1] = true;

        for (int i = 2; i * i < n; i++) {

            if (! isPrime[i]) {
                for (int j = i  * i; j < n; j += i)
                    isPrime[j] = true;
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {
        int n = 50;
        boolean[] isPrime = sieveOfEratosthenes(n + 1);


        for (int i = 0; i < n; i++) {
            if ( ! isPrime[i])
                System.out.print(i + " ");
        }
    }
}

package com.techcrack.dsa.strings;

public class MinOperationsToSortString {
    static final int MOD = 1_000_000_007;

    // Precompute factorials up to the max possible length
    public static long[] computeFactorials(int n) {
        long[] fact = new long[n + 1];
            fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        return fact;
    }

    // Compute modular inverse of a number using Fermat's Little Theorem
    public static long modularInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    // Exponentiation by squaring
    private static long power(long x, long y, int mod) {
        long result = 1;
        x = x % mod;
        while (y > 0) {
            if ((y & 1) == 1) result = (result * x) % mod;
            x = (x * x) % mod;
            y >>= 1;
        }
        return result;
    }

    public static int makeStringSorted(String s) {
        int n = s.length();
        long[] fact = computeFactorials(n);

        // Frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);

            // Count permutations for characters smaller than the current character
            for (int ch = 0; ch < current - 'a'; ch++) {
                if (freq[ch] > 0) {
                    freq[ch]--;
                    long perms = fact[n - i - 1];

                    // Adjust for repeated characters
                    for (int f : freq) {
                        if (f > 1) {
                            perms = (perms * modularInverse(fact[f], MOD)) % MOD;
                        }
                    }

                    result = (result + perms) % MOD;
                    freq[ch]++;
                }
            }

            // Reduce the frequency of the current character as it's processed
            freq[current - 'a']--;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(makeStringSorted(s)); // Output: 5
    }
}

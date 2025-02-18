package com.techcrack.dsa.strings;

public class SumMinSortOperation {
    public int makeStringSorted(String s) {
        int MOD = 1_000_000_007;

        long result = 0;

        int[] freq = new int[26];

        char[] sArr = s.toCharArray();

        for (char ch : sArr) {
            freq[ch - 'a']++;
        }        
        int n = sArr.length;

        long[] fact = computFactorial(n, MOD);

        for (int i = 0; i < n; i++) {
            char ch = sArr[i];

            int totFreq = 0;
            long perms = fact[n - i - 1]; 
            for (int j = 0; j < ch - 'a'; j++) {
                totFreq += freq[j];
            }

            for (int f : freq) {
                if (f > 1)
                    perms = perms * modInverse(fact[f], MOD) % MOD;
            }

            perms = perms * totFreq % MOD;

            result = (result + perms) % MOD;



            freq[ch - 'a']--;
        }

        return (int)result;
    }



    protected long[] computFactorial(int n, int MOD) {
        long[] fact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD; 
        }

        return fact;
    }

    protected long modInverse(long x, int MOD) {
        return modExpo(x, MOD - 2, MOD);
    }

    protected long modExpo(long x, int y, int MOD) {
        long result = 1;


        while (y > 0) {
            if ((y & 1) == 1)
                result = result * x % MOD;
            
            x = x * x % MOD;
            y >>= 1;
        }
        return result;
    }
}
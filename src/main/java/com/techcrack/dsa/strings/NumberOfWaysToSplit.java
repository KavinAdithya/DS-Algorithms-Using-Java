package com.techcrack.dsa.strings;

public class NumberOfWaysToSplit {
    public int numWays1(String s) {
        long MODULO = 1_000_000_007;
        long countOnes = 0;
        long n = s.length();

        for (char ch : s.toCharArray())
            countOnes += ch - '0';

        if (countOnes == 0)
            return (int) ((((n - 1) * (n - 2)) / 2) % MODULO );

        if (countOnes % 3 != 0)
            return 0;

        long onesRange = countOnes / 3;

        long firstGap = 0;
        long secondGap = 0;
        long oneSum = 0;

        for (char ch : s.toCharArray()) {
            oneSum += ch - '0';

            if (oneSum == onesRange)
                firstGap++;
            if (oneSum == 2 * onesRange)
                secondGap++;
        }


        return (int) (firstGap * secondGap % MODULO);
    }


    public int numWays(String s) {
        long MOD = 1_000_000_007;
        int ones = 0;


        long n = s.length();

        for (int i = 0; i < n; i++) {
            ones += s.charAt(i) - '0';
        }

        if (ones == 0)
            return (int) ((n - 1) * (n - 2) / 2 % MOD);

        if (ones % 3 != 0)
            return 0;

        long equalParts = ones / 3;
        long sumParts = 0;
        long firstCuts = 0;
        long secondCuts = 0;

        for (int i = 0; i < n; i++) {
            sumParts += s.charAt(i) - '0';

            if (sumParts == equalParts)
                firstCuts++;

            if (sumParts == 2 * equalParts)
                secondCuts++;
        }

        return (int)(firstCuts * secondCuts % MOD);

    }
}

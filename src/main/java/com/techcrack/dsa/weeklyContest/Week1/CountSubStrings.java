package com.techcrack.dsa.weeklyContest.Week1;

public class CountSubStrings {

    // Brute Force
    public int numberOfSubstrings1(String s) {
        int satisfiedString = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            long ones = 0;
            long zeros = 0;

            for (int j = i; j < length; j++) {
                char binaryCharacter = s.charAt(j);

                if (binaryCharacter == '0')
                    zeros++;
                else
                    ones++;

                if (ones >= zeros * zeros)
                    satisfiedString++;
            }
        }

        return satisfiedString;
    }

    public int numberOfSubstrings(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int n = s.length();

        int[] prefixSum = new int[n + 1];

        findPrefixSum(s, prefixSum);

        return countSubStringWithDominant(s, prefixSum, n);
    }

    public void findPrefixSum(String s, int[] prefixSum) {
        if (s.charAt(0) == '1')
            prefixSum[1] = 1;

        for (int i = 1; i < s.length() ; i++) {
            if (s.charAt(i) == '1')
                prefixSum[i + 1] = prefixSum[i] + 1;
            else
                prefixSum[i + 1] = prefixSum[i];
        }
    }

    public int countSubStringWithDominant(String s, int[] prefixSum, int length) {
        int ans = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int ones = prefixSum[j + 1] - prefixSum[i];
                int zeros = (j - i + 1) - ones;
                int zerosSquare = zeros * zeros;

                if (zerosSquare > ones)
                    j += (zerosSquare - ones - 1);
                else if (zerosSquare == ones)
                    ans++;
                else {
                    int differenceDigits = (int)Math.sqrt(ones) - zeros;
                    int totalDifference = differenceDigits + j;

                    if (totalDifference >= length)
                        ans += (length - j);
                    else
                        ans += differenceDigits + 1;

                    j = totalDifference;

                }

            }
        }

        return ans;
    }
}

package com.techcrack.dsa.strings;

public class WaysSplitString {
    static int numWays(String s) {
        int n = s.length();

        int numOnes = 0;

        for (int i = 0; i < n; i++) {
            numOnes += (s.charAt(i) - '0');
        }

        if (numOnes % 3 != 0)
            return 0;

        int[] preSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (s.charAt(i) - '0');
        }


        int subPart = numOnes / 3;
        int waysSplit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int firstPart = preSum[i + 1] - preSum[0];
                int secondPart = i + 1 == n ? 0 : preSum[j + 1] - preSum[i + 1];
                int thirdPart = j + 1 == n ? 0 : preSum[n] - preSum[j + 1];

                if (firstPart == subPart && firstPart == secondPart && secondPart == thirdPart)
                    waysSplit++;
            }
        }

        return waysSplit % 1_000_000_007;
    }

    public static void main(String[] args) {
        System.out.println(numWays("10101"));
    }
}

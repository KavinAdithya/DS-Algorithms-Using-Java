package com.techcrack.DSA.weeklyContest.Week1;

public class FindGreaterGame {
    public boolean canAliceWin(int[] nums) {
        int singleDigit = 0;
        int doubleDigit = 0;

        for (int num : nums) {
            if (num <= 9)
                singleDigit += num;
            else
                doubleDigit += num;
        }

        return singleDigit != doubleDigit;
        }
}

package com.techcrack.DSA.WeeklyContest.Week1;

class Solution {
    public int nonSpecialCount(int l, int r) {
        int notSpecial = 0;

        for (int i = l; i < r + 1; i++) {
            if ((i != 2 && i != 4 && i % 2 == 0) || (i != 5 && i % 5 == 0)) {
                notSpecial++;
                continue;
            }

            if(findCount(i))
                notSpecial++;    
        }

        return notSpecial;
    }

    public boolean findCount(int target) {
        int divisors = 0;

        for (int i = 1; i < target; i++) {
            if (target % i == 0)
                divisors++;
            if (divisors > 2)
                return true;
        }

        return divisors < 2;
    }
}
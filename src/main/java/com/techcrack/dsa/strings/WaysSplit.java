package com.techcrack.dsa.strings;

class WaysSplit {
    public int numWays(String s) {
        long length = s.length();

        char[] sArray = s.toCharArray();

        long MOD = 1_000_000_007;
        long ones = 0;

        for (char ch : sArray) {
            if (ch == '1')
                ones++;
        }

        if (ones == 0)
            return (int) (( (length - 1) * (length - 2) / 2 ) % MOD);
        
        if (ones % 3 != 0)
            return 0;
        
        long subValue = ones / 3;

        long first = 0;
        long second = 0;
        long sum = 0;

        for (char ch : sArray) {
            sum += (ch - '0');

            if ( sum == subValue)
                first++;
            if (sum == subValue * 2)
                second++;
        }

        return (int) ((first * second) % MOD);
    }
}
package com.techcrack.DSA.Strings;

class CountNumberOfHomogenousSubstrings {
    public int countHomogenous(String s) {
        int i = 0, j = 0;
        long sum = 0;
        
        char[] sArray = s.toCharArray();

        while (i < sArray.length) {
            
            if (sArray[i] == sArray[j]) {
                sum += (i - j + 1);
                i++;
            } 
            else 
                j = i;
            
        }

        return (int) (sum % 1_000_000_007);
    }

    // Brute Force
    public int countHomogenous1(String s) {
        int MODULO = 1_000_000_007;

        int homogenousCount = 0;

        for (int i = 0; i < s.length(); i++) {

            int j = i;

            for (; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j))
                    break;
            }

            homogenousCount += j - i;
        }

        return homogenousCount;
    }

    public int countHomogenous4(String s) {
        int i = 0;
        int j = 0;
        long MODULO = 1_000_000_007;
        int length = s.length();
        long result = 0;

        while (j < length) {
            if (s.charAt(i) == s.charAt(j))
                result += (j - i + 1);
            else {
                result++;
                i = j;
            }
            j++;
        }

        return (int) (result % MODULO);
    }
}
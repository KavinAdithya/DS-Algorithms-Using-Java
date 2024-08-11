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
}
package com.techcrack.DSA.strings;

class CustomStringSort {
    public String customSortString(String order, String s) {
        int[] orderHashing = new int[26];
        int[] sHashing = new int[26];


        for (int i = 0; i < order.length(); i++)
            orderHashing[order.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++)
            sHashing[s.charAt(i) - 'a']++;
        
        StringBuilder permutatedString = new StringBuilder();

        int oPointer = 0;

        while (oPointer < order.length()) {
            char ch = order.charAt(oPointer);

            if (sHashing[ch - 'a'] != 0) {
                permutatedString.append(ch);
                sHashing[ch - 'a']--;
            }
            else
                oPointer++;
        }


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (orderHashing[ch - 'a'] == 0) 
                permutatedString.append(ch);
        }

        return permutatedString.toString();
    }
}
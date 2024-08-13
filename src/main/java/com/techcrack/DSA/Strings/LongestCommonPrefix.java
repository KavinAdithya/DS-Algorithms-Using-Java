package com.techcrack.DSA.Strings;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        

        int indexLength = 201;
        int index = 0;
        int i = 0;

        for (String str : strs) {
            if (indexLength > str.length()) {
                indexLength = str.length();
                index = i; 
            }
            i++;
        }

        String s = strs[index];

        for (i = 0; i < s.length(); i++) {

            for (String str : strs) {
                if (str.charAt(i) != s.charAt(i)) {
                    return s.substring(0, i);
                }
            }
        }

        return s;
    }
}
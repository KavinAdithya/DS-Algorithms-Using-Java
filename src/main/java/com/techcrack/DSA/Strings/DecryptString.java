package com.techcrack.DSA.Strings;

class DecryptString {
    public String freqAlphabets(String s) {
       
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        char[] sChars = s.toCharArray();

        for (int i = length - 1; i > -1; i--) {
            if (sChars[i] == '#' && i > 1) {

                int digit = (sChars[i - 2] - '0') * 10 + (sChars[i - 1] - '0');
               
                sb.append((char) (digit + 96));
                i -= 2; 
            }
            else {
                int digit = (sChars[i] - '0') + 96;
                sb.append((char)digit);
            }
        }

        return sb.reverse().toString();

    }
}
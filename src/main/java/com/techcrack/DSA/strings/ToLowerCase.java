package com.techcrack.DSA.strings;

class ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            ch = ch >= 'A' && ch <= 'Z' ? (char) ((int)ch + 32) : ch;
            sb.append(ch); 
        }

        return sb.toString();

    }
}
package com.techcrack.DSA.recursion.strings;

public class FirstUppercase {
    static char upperFirst(String s, int index) {
        if (index + 1 == s.length()) return ' ';

        char ch = s.charAt(index);

        if (Character.isUpperCase(ch))
            return ch;

        return upperFirst(s, index + 1);
    }

    public static void main(String[] args) {
        String s = "geeksforgeeKs";

        System.out.println(upperFirst(s, 0));
    }
}

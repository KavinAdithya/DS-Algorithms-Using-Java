package com.techcrack.dsa.recursion.strings;

public class RemoveConsecutiveDuplicates {

    public static String remConsDup(String s, StringBuilder unique, int index) {
        if (index == s.length()) {
            return unique.toString();
        }

        unique.append(s.charAt(index));

        index++;

        while (index < s.length() && s.charAt(index - 1) == s.charAt(index)) {
            index++;
        }

        return remConsDup(s, unique, index);
    }

    public static void main(String[] args) {
        System.out.println(remConsDup("aaaabbbababbbabccccc", new StringBuilder(), 0));
    }
}

package com.techcrack.dsa.recursion.strings;

public class SkipWord {

    static void skipWord(String str, String word, int index, StringBuilder ans) {
        if (str == null || word == null || index >= str.length()) return;

        int n = word.length();

        if (str.substring(index).startsWith(word))
            index += n;
        else {
            ans.append(str.charAt(index));
            index += 1;
        }

        skipWord(str, word, index, ans);
    }

    public static void main(String[] args) {
        String str = "orange apple orangeappleorangeabcdapple";
        String word = "orange";

        StringBuilder ans = new StringBuilder();
        skipWord(str, word, 0, ans);

        System.out.println(ans);
    }
}

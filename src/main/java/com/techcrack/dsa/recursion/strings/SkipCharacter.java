package com.techcrack.dsa.recursion.strings;

public class SkipCharacter {
    static void skipCharacter(String str, char skip, int index, StringBuilder ans) {
        if (str == null || str.isEmpty() || str.length() == index)
            return;

        if (str.charAt(index) != skip)
            ans.append(str.charAt(index));

        skipCharacter(str, skip, index + 1, ans);
    }

    public static void main(String[] args) {
        String str = "qawaearatayauiaoapasafagahaka";
        char ch = 'a';

        var ans = new StringBuilder();

        skipCharacter(str, ch, 0, ans);

        System.out.println(ans );
    }
}

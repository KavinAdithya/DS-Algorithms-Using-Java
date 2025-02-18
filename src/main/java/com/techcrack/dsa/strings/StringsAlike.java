package com.techcrack.dsa.strings;

import java.util.Set;

class StringsAlike {
    public boolean halvesAreAlike1(String s) {
        int length = s.length();
        int divider = length / 2;
        

        Set<Character> hashing = Set.of('a','e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

   

        int leftString = countVowels1(s, 0, divider , hashing);
        int rightString = countVowels1(s, divider , length, hashing);



        return leftString == rightString;
    }

    public int countVowels1(String str, int start, int end, Set<Character> hashing) {
        int vowelsCount = 0;

        for (int i = start; i < end; i++) {
            if (hashing.contains(str.charAt(i)))
                vowelsCount++;
        }

        return vowelsCount;
    }


    public boolean halvesAreAlike(String s) {
        int length = s.length();
        int divider = length / 2;

        boolean[] hashing = new boolean[128];

        hashing['a'] = true;
        hashing['e'] = true;
        hashing['i'] = true;
        hashing['o'] = true;
        hashing['u'] = true;
        hashing['A'] = true;
        hashing['E'] = true;
        hashing['O'] = true;
        hashing['I'] = true;
        hashing['U'] = true;



        int leftString = countVowels(s, 0, divider , hashing);
        int rightString = countVowels(s, divider , length, hashing);



        return leftString == rightString;
    }

    public int countVowels(String str, int start, int end, boolean[] hashing) {
        int vowelsCount = 0;

        for (int i = start; i < end; i++) {
            if (hashing[str.charAt(i)])
                vowelsCount++;
        }

        return vowelsCount;
    }
}
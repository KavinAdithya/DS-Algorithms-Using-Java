package com.techcrack.DSA.strings;

class Pangram {
    public boolean checkIfPangram(String sentence) {
        int[] alphaHash = new int[26];

        for (int i = 0; i < sentence.length(); i++)
            alphaHash[sentence.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (alphaHash[i] == 0)
                return false;
        }

        return true;

    }
}
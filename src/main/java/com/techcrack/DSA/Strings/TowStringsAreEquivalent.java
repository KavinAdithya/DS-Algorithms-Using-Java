package com.techcrack.DSA.Strings;

public class TowStringsAreEquivalent {
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder word1String = new StringBuilder();

        for (String s : word1)
            word1String.append(s);

        StringBuilder word2String = new StringBuilder();

        for (String s : word2)
            word2String.append(s);



        return word1String.toString().equals(word2String.toString());
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, characterPointer1 = 0;
        int j = 0, characterPointer2 = 0;

        int length1 = word1.length;
        int length2 = word2.length;

        while (i < length1 && j < length2) {
            if (word1[i].charAt(characterPointer1) != word2[j].charAt(characterPointer2))
                return false;

            characterPointer1++;
            if (characterPointer1 == word1[i].length()) {
                i++;
                characterPointer1 = 0;
            }

            characterPointer2++;
            if (characterPointer2 == word2[j].length()) {
                j++;
                characterPointer2 = 0;
            }
        }

        return i == length1 && j == length2;
    }
}

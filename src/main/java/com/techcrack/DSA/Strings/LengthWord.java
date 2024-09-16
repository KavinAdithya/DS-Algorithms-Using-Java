package com.techcrack.DSA.Strings;

class LengthWord {
    public int lengthOfLastWord(String s) {
        int lengthWord = 0;
        boolean isInitialSpace = true;

        for (int i = s.length() - 1; i > - 1; i--) {
            char ch = s.charAt(i);

            if (ch == ' ' && isInitialSpace)
                continue;
            else if (ch != ' ') {
                isInitialSpace = false;
                lengthWord++;
            }
            else 
                return lengthWord;
        }

        return lengthWord;
    }
}
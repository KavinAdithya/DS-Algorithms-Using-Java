package com.techcrack.DSA.strings;

class ReversePrefix {
    public String reversePrefix(String word, char ch) {
      //  int index = word.indexOf(String.valueOf(ch));

        int index = findFirstOccurence(word, ch);

        if (index == -1)
            return word;
        
        return reverseIt(word, index);
    }


    private String reverseIt(String word, int end) {
        char[] prefixReverse = word.toCharArray();

        int start = 0;

        while (start < end) {
            
            char ch = prefixReverse[start];
            prefixReverse[start] = prefixReverse[end];
            prefixReverse[end] = ch;

            start++;
            end--;
        }

        return new String(prefixReverse);
    }


    private int findFirstOccurence(String word, char ch) {
        
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch)
                return i;
        }

        return -1;
    }
}
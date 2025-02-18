package com.techcrack.dsa.strings;

class ReverseStringIII {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        StringBuilder[] reversingWord = new StringBuilder[words.length];

        for (int i = 0; i < words.length; i++) 
            reversingWord[i] = new StringBuilder(words[i]).reverse();
        
        StringBuilder reversedString = new StringBuilder();

        for (StringBuilder word : reversingWord)
            reversedString.append(word).append(" ");
        
        reversedString.deleteCharAt(reversedString.length() - 1);
        
        return reversedString.toString();
    }
}
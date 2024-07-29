package com.techcrack.DSA.Strings;

public class SortingSentences {
    public String sortSentence1(String s) {
        String[] words = s.split(" ");

        String[] sortedString = new String[words.length];

        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '1';
            sortedString[index] = word;
        }

        StringBuilder result = new StringBuilder();

        for (String sort : sortedString) {
            result.append(sort);
            result.append(" ");
        }

        for (int i = 0; i < result.length(); i++) {
            char character = result.charAt(i);

            if (character >= '1' && character <= '9')
                result.deleteCharAt(i);
        }

        result.deleteCharAt(result.length() - 1);

        return new String(result);
    }

    public String sortSentence(String s) {
        String[] words = s.split(" ");

        String[] sortedString = new String[words.length];

        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '1';
            sortedString[index] = word.substring(0, word.length() - 1);
        }

        StringBuilder result = new StringBuilder();

        for (String sort : sortedString) {
            result.append(sort).append(" ");
        }



        result.deleteCharAt(result.length() - 1);

        return new String(result);
    }
}

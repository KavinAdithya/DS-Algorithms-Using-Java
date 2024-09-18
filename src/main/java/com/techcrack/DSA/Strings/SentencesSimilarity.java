package com.techcrack.DSA.Strings;

import java.util.ArrayList;
import java.util.List;

class SentencesSimilarity {
    public boolean areSentencesSimilar1(String sentence1, String sentence2) {
      
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        if (words1.length < words2.length)
            return areSentencesSimilar1(sentence2, sentence1);

        if (words1.length == words2.length)
            return sentence1.equals(sentence2);


        List<Integer> missingIndex = new ArrayList<>();
        List<Integer> foundedIndex = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < words1.length; i++) {
            String s1 = words1[i];
            String s2 = j < words2.length ? words2[j] : null;

            if (s2 == null)
                missingIndex.add(i);
            else if(! s1.equals(s2)) {
                missingIndex.add(i);
                j--;
            }
            else
                foundedIndex.add(i);
            j++;
        }

        System.out.println(j  + " " + missingIndex + " " + foundedIndex);
        if (missingIndex.size() + j == words1.length && j  != words2.length)
            return false;
        

        for (int i = 1; i < missingIndex.size(); i++)
            if (missingIndex.get(i) - missingIndex.get(i - 1) != 1)
                return false;
        
        return true;
    }

    public boolean areSentencesSimilar2(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int length1 = words1.length;
        int length2 = words2.length;

        if (length1 > length2)
            return areSentencesSimilar2(sentence2, sentence1);

        int i = 0;

        while (i < length1 && words1[i].equals(words2[i]))
            i++;

        while (i < length1 && words1[i].equals(words2[i + length2 - length1]))
            i++;

        return i == length1;
    }

    public boolean areSentencesSimilar3(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int length1 = s1.length;
        int length2 = s2.length;

        if (length1 > length2)
            return areSentencesSimilar3(sentence2, sentence1);

        int i = 0;

        while (i < length1 && s1[i].equals(s2[i]))
            i++;

        while (i < length1 && s1[i].equals(s2[length2 - (length1 - i)]))
            i++;

        return i == length1;
    }

    public boolean areSentencesSimilar4(String sentence1, String sentence2) {
        int i = 0;

        String[] s1Array = sentence1.split(" ");
        String[] s2Array = sentence2.split(" ");


        int length1 = s1Array.length;
        int length2 = s2Array.length;

        if (length2 > length1)
            return areSentencesSimilar4(sentence2, sentence1);

        while (i < length2 && s1Array[i].equals(s2Array[i]))
            i++;

        while (i < length2 && s2Array[i].equals(s1Array[length1 - (length2 - i)]))
            i++;

        return i == length2;
    }
}
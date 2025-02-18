package com.techcrack.dsa.strings;

class MaximumRepeating {
    public int maxRepeating(String sequence, String word) {
    
        int length = sequence.length();
        StringBuilder str = new StringBuilder(word);


        for (int i = 0; i < length; i++) {
            if (sequence.contains(str.toString()))
                str.append(word);
            else
               return i ;
        }

        return length;
    }
}
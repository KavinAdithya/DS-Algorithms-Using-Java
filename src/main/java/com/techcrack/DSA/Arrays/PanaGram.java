package com.techcrack.DSA.Arrays;

public class PanaGram {
    /*
     *Given a String We needed to find the string contains all
     * english small alphabets if return true or false
     */
    public boolean checkIfPangram(String sentence) {
        int[] alpha=new int[26];

        for(char c:sentence.toCharArray())
            alpha[c-'a']++;
        for(int k:alpha){
            if(k==0)
                return false;
        }

        return true;
    }

    public boolean panagram(String sentence){
        int count=0;
        for(char ch='a';ch<='z';ch++){
            if(sentence.indexOf(ch)==-1)
                count++;
        }
        if(count==0)
            return true;
        return false;
    }

}

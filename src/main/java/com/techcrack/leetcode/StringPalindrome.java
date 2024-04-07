package com.techcrack.leetcode;

public class StringPalindrome {
    public boolean isPalindromeOurAnswer(String s) {
        StringBuilder str =new StringBuilder();
        s=s.toLowerCase();
        for(char ch:s.toCharArray()){
            if((ch>='a'&&ch<='z')||(ch>='0'&&ch<='9'))
                str.append(ch);
        }
        return checkPalindrome(str);
    }
    private boolean checkPalindrome(StringBuilder str){
        int length=str.length()-1;
        for(int k=0;k<length-k;k++){
            if(str.charAt(k)!=str.charAt(length-k))
                return false;
        }
        return true;
    }
    public boolean checkThePalindrome(String s){
        int first=0;
        int last=s.length()-1;
        while(first<last){
            char firstCharacter=s.charAt(first);
            char lastCharacter=s.charAt(last);
            if(!Character.isLetterOrDigit(firstCharacter))
                first++;
            else if(!Character.isLetterOrDigit(lastCharacter))
                last--;
            else{
                if(Character.toLowerCase(firstCharacter)!=Character.toLowerCase(lastCharacter))
                    return false;
                last--;
                first++;
            }
        }
        return true;
    }
}

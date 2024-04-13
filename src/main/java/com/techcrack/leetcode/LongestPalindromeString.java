package com.techcrack.leetcode;

public class LongestPalindromeString {

    /*
    *To find the Longest Palindrome substring in a string
     */
    public String longestPalindrome(String s) {
        char[] array=s.toCharArray();
        int start=0;
        int end=0;
        int length=0;
        for(int k=0;k<s.length()-1;k++){

            for(int d=k+1;d<s.length();d++){

                if(palindrome(array,k,d)){
                    if((d-k+1)>length) {
                        start=k;
                        end=d;
                        length=(d-k+1);
                    }
                }
            }
        }
        return convertString(array,start,end);
    }

    //Checking the given number is palindrome Or Not
    private boolean palindrome(char[] array,int start,int end){
        while(start<end){
            if(array[start]!=array[end])
                return false;
            start++;
            end--;
        }
        return true;
    }


    //Converting Array Into String
    private String convertString(char[] array,int start,int end){

        StringBuilder sb=new StringBuilder();

        for(;start<=end;start++){
            sb.append(array[start]);
        }

        return sb.toString();
    }



    //Optimized Logic Leaarned From Others Answer
    //Time Complexity O(n^2)


    public String subString(String s){
        String max=s.substring(0,1);

        for(int k=0;k<s.length()-1;k++){

            String odd=palindrome1(s,k,k);
            String even=palindrome1(s,k,k+1);

            if(odd.length()>max.length())
                max=odd;
            else if(even.length()>max.length())
                max=even;
        }
        return max;
    }

    private String palindrome1(String s,int start,int end){
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}

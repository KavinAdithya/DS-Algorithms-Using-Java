package com.techcrack.leetcode;
import java.util.*;
public class LongestSubstringWithoutDuplicates {
    public static int findLongestWord(String s){
        int left=0;
        int maxLength=0;
        Set<Character> set=new HashSet<Character>();
        for(int right=0;right<s.length();right++){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                //maxLength=Math.max(maxLength,right-left+1);
            }
            else{
//                while(set.contains(s.charAt(right))){
//                    set.remove(s.charAt(left));
//                    left++;
//                }
                maxLength=Math.max(set.size(),maxLength);
                left=right;
                set.clear();
                set.add(s.charAt(right));

            }
        }
        maxLength=Math.max(set.size(),maxLength);
        return maxLength;
    }
    public static void main(String[] args){
        System.out.println(findLongestWord("pwwkew"));
    }
}

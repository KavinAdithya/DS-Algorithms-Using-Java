package com.techcrack.leetcode;

public class LongestCommonPrefix{
    public static void main(String[] args){
        String s[]={"flower","flow","flight"};
        String k=s[0];
        for(String ss:s){
            while(ss.indexOf(k)!=0){
                System.out.println(k+" "+ss.indexOf(k)+" "+ss);
                k=k.substring(0,k.length()-1);
            }
        }
        System.out.println(k);
        System.out.println("kavinnn".indexOf("kavinn"));
    }
}
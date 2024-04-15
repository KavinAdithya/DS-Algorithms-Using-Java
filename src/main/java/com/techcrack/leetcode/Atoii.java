package com.techcrack.leetcode;

public class Atoii {
        public static int myAtoi(String s) {
            long sum=0;
            long ide=1;
            for(char ch:s.toCharArray()){
                if(ch=='-')
                    ide=-1;
                if(ch>='0'&&ch<='9'){
                    sum=(sum*10)+(ch-'0');
                }
                else if(ch!=' '&&ch!='-'&&ch!='+')
                    break;
            }
            if(sum>Integer.MAX_VALUE&&ide==-1)
                return Integer.MIN_VALUE;
            else if(sum>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            return (int)(sum*ide);
        }
    public static void main(String[] args){
     System.out.println(myAtoi("+-12"));
    }
}

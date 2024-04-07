package com.techcrack.leetcode;

public class BinaryAddittion {
    public long addTheCarry(long number){
        int hundredsCount=10;
        if(number==0)
                return 0;
        else if(number==1)
                return 1;
        long previous=1;
        long n=1;
        for(int k=2;k<=number;k++){
            if(checkTheNumberIsFull(previous)) {
                previous = hundredsCount;
                hundredsCount *= 10;
                n=1;
            }
            else{
                previous+=n;
                n*=10;
            }
        }
        return previous;
    }
    public  boolean checkTheNumberIsFull(long n){
        while(n!=0){
            if(n%10==0)
                return false;
            n/=10;
        }
        return true;
    }
    //try it myself Its A Worst case in both the space and time excution
    public String binaryAdd(String n1,String n2){
        String answer="";
        long carry=0;
        int  s1=n1.length()-1;
        int s2=n2.length()-1;
        long value=0;
        long fina=0;
        while(s1>=0||s2>=0||carry!=0){
            if(s1<0){
                fina=(((long)n2.charAt(s1))-48)+carry;
                value=addTheCarry(fina);
            }
            else if(s2<0){
                fina=(((long)n1.charAt(s1))-48)+carry;
                value=addTheCarry(fina);
            }
            else if(s1>=0&&s2>=0){
                fina=(((long)n2.charAt(s1))-48)+(((long)n1.charAt(s1))-48)+carry;
                value=addTheCarry(fina);
            }
            else
                value=addTheCarry(carry);
            answer=(value%10)+answer;
            s1--;
            s2--;
            carry=value/10;
        }
        return answer;
    }
    //Optimized Solution Learninng from others solutiion
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder answer=new StringBuilder();
            int carry=0;
            int i=a.length()-1;
            int j=b.length()-1;
            while(i>=0||j>=0||carry==1){
                if(i>=0)
                    carry+=a.charAt(i--)-'0';
                if(j>=0)
                    carry+=b.charAt(j--)-'0';
                answer.append(carry%2);
                carry/=2;
            }
            return answer.reverse().toString();
        }
    }
}

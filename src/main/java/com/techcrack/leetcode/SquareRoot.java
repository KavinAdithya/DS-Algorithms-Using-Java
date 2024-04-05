package com.techcrack.leetcode;

public class SquareRoot {

    //reversing of a Number
    private int reverseTheNumber(int number){
        int answer=0;

        while(number!=0){
            answer=(answer*100)+(number%100);
            number/=100;
        }
        return answer;
    }

    private int generateNearestSquareRoot(int side,int remainder){
        side*=10;
        int near=1;
        while(((side+near)*near)<=remainder)
            near++;
        return --near;
    }

    public int mainSquareRoot(int number){
        int rtn=reverseTheNumber(number);
        int side=0;
        int remainder=0;
        int quotient=0;
        System.out.println(rtn);

        while(rtn!=0){
            int divide;
            if(number<10)
                divide=rtn%10;
            else
                divide=(remainder*100)+rtn%100;
            int n=generateNearestSquareRoot(side,divide);
            System.out.println(n);
            side=(side*10)+n;
            quotient=(quotient*10)+n;
            remainder=divide-(side*n);
            side+=n;
            rtn/=100;
        }
        return quotient;
    }
}

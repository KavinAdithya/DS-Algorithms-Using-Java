package com.techcrack.leetcode;

public class SquareRoot {
    int counter=0;
    //reversing of a Number
    private long reverseTheNumber(int number){
        long answer=0;

        while(number!=0){
            counter++;
            answer=(answer*100)+(number%100);
            number/=100;
        }
        return answer;
    }

    private long generateNearestSquareRoot(long side,long remainder){
        side*=10;
        long near=1;
        while(((side+near)*near)<=remainder)
            near++;
        return --near;
    }

    public int mainSquareRoot(int number){
        long rtn=reverseTheNumber(number);
        long side=0;
        long remainder=0;
        long quotient=0;
        int local=0;
        System.out.println(rtn);
        boolean bool=false;

        while(rtn!=0||bool){
            local++;
            long divide;
            if(number<10)
                divide=rtn%10;
            else
                divide=(remainder*100)+rtn%100;
            long n=generateNearestSquareRoot(side,divide);
            System.out.println(n);
            side=(side*10)+n;
            quotient=(quotient*10)+n;
            remainder=divide-(side*n);
            side+=n;
            rtn/=100;
            if(rtn==0){
                if(local<counter) {
                    bool = true;
                    continue;
                }
            }
            bool=false;
        }

        return (int)quotient;
    }
    public int rootBinarySearch(int number){
        long answer=0;
        long start=1;
        long end=number;

        while(start<=end){
            long mid=(end+start)/2;
            if((mid*mid)==number)
                return (int)mid;
            else if((mid*mid)<number){
                answer=mid;
                start=mid+1;
            }
            else
                end=mid-1;
        }
        return (int)answer;
    }
    public int rootBinarySearch2(int number){
        long start=1;
        long end=number;

        while(start<=end){
            long mid=(end+start)/2;
            if((mid*mid)==number)
                return (int)mid;
            else if((mid*mid)<number)
                start=mid+1;
            else
                end=mid-1;
        }
        return (int)end;
    }
}

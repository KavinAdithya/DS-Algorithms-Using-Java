package com.techcrack.DSA.ArraysAndBS;

public class ReachNumber {
    public int reachNumber(int target) {
        target = Math.abs(target);

        long start = 1;
        long end = target;
        long steps = 0;


        while(start <= end){

            long mid = (start + end) / 2;
            long midSum = mid * (mid + 1) / 2;
            if(midSum == target)
                return (int)mid;
            else if(midSum > target){
                steps = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        long moves = steps * (steps + 1) / 2;
        //System.out.println("Steps = " + steps + " Move Sum " + moves);
        if((moves - target ) % 2 == 0)
            return (int)steps;
        else {
            if(steps % 2 == 0)
                return (int)steps + 1;
            return (int)steps + 2;
        }
    }

    //Revisited Answer
    public int reachNumber1(int target) {
        long target1 = Math.abs(target);

        long start = 1;
        long end = target1 ;


        while(start <= end){
            long mid = (start + end) / 2;

            long midSum = mid * (mid + 1) / 2;

            if(midSum == target1)
                return (int)mid;
            else if(midSum > target1)
                end = mid - 1;
            else
                start = mid + 1;

        }

        long startSum = start * (start + 1) / 2;

        if((startSum - target1) % 2 == 0 )
            return (int)start;
        else {
            if(end % 2 == 0)
                return (int)start + 2;
            else
                return (int)start + 1;
        }

    }
}
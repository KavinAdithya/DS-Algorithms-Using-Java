package com.techcrack.DSA.Arrays;

public class ReachNumber {
    public int reachNumber(int target) {
        long start = 1;
        target = Math.abs(target);
        long end=target,sum=0,step=0;

        while(start <= end){
            long mid = ( start + end ) / 2;
            long sumOf = mid * (mid + 1 ) / 2;
            if(sumOf == target)
                return (int)mid;
            else if(sumOf > target){
                step = mid;
                sum = sumOf;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        if((sum - target) % 2 == 0)
            return (int)step;
        else{
            if(step%2 == 0)
                return (int)++step;
            else
                return (int)step+2;
        }
    }

}

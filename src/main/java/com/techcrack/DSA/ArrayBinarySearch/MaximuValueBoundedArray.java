package com.techcrack.DSA.ArrayBinarySearch;

public class MaximuValueBoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        long start = 1;
        long end = maxSum;
        long leftLength = index ;

        long rightLength = n - index - 1;


        while(start<=end){

            long mid = (start + end) / 2;

            mid--;

            long sum = mid * (mid + 1) / 2;

            long rightSum=sum;

            if(mid - rightLength > 0){
                long diff = mid - rightLength;

                long sumRight = diff * (diff + 1) / 2;

                rightSum-=sumRight;
            }

            long leftSum=sum;

            if(mid - leftLength > 0){
                long diff1 = mid -  leftLength;

                long sumLeft = diff1 * (diff1+1) / 2;

                leftSum-=sumLeft;
            }
            if(leftLength - mid > 0)
                leftSum += leftLength - mid;
            if(rightLength - mid > 0)
                rightSum += rightLength - mid;

            mid++;

            sum = leftSum + rightSum + mid;


            if(sum == maxSum)
                return (int)mid;
            else if(sum > maxSum)
                end = mid - 1;
            else
                start = mid + 1;
        }


        return (int)end;

    }
}

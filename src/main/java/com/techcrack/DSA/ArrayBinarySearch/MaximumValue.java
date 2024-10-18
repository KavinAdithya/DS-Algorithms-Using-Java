package com.techcrack.DSA.ArrayBinarySearch;

public class MaximumValue {
    public int maxValue(int n, int index, int maxSum) {
        long start = 1;
        long end = maxSum;


        while(start <= end){
            long mid = (start + end) / 2;

            if(isMaximumValue(mid, maxSum, index, n))
                start = mid + 1;
            else
                end = mid - 1;
        }

        return (int)end;
    }

    private boolean isMaximumValue(long maximum, long maxSum, int index, int size){
        long leftLength = index ;
        long rightLength = size - index ;
        long rightSum = maximum * (maximum + 1) / 2;

        long rightRemain = rightLength - maximum;
        if(rightRemain >= 0)
            rightSum += rightRemain;
        else{
            rightRemain *= -1;
            long rightRemainSum = rightRemain * (rightRemain + 1) / 2;
            rightSum -= rightRemainSum;
        }

        maximum--;
        long leftSum = maximum * (maximum + 1) / 2;

        long leftRemain = leftLength - maximum;
        if(leftRemain >= 0)
            leftSum += leftRemain;
        else{
            leftRemain *= -1;
            long leftRemainSum = leftRemain * (leftRemain + 1) / 2;
            leftSum -= leftRemainSum;
        }


        return leftSum + rightSum <= maxSum;

    }
}

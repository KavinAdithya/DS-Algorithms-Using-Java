package com.techcrack.DSA.Sorting;

class MaximumProductTwoElements {
    public int maxProduct(int[] nums) {
        int fMax = 0;
        int sMax = 0;

        for (int n : nums) {
            if (n >= fMax) {
                sMax = fMax;
                fMax = n;
            }
            else if (n >= sMax) {
                sMax = n;
            }
        }        

        return (fMax - 1) * (sMax - 1);
    }
}
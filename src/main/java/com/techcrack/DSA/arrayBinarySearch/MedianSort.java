package com.techcrack.DSA.arrayBinarySearch;

public class MedianSort {
    //Binary Search
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int median = (n1 + n2 + 1) / 2;
        int start = 0;
        int end = n1 ;

        while(start <= end){

            int mid = (start + end) / 2;
            int mid1 = median - mid;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;

            if(mid < n1)
                r1 = nums1[mid];
            if(mid1 < n2)
                r2 = nums2[mid1];
            if(mid > 0)
                l1 = nums1[mid - 1];
            if(mid1 > 0)
                l2 = nums2[mid1 - 1];

            if(l1 <= r2 && l2 <= r1){
                int m1 = l1 > l2 ? l1 : l2;
                int m2 = r1 < r2 ? r1 : r2;
                if((n1 + n2) % 2 == 0)
                    return ((double)(m1 + m2)) / 2.0;
                return m1;
            }
            else if(l1 > r2)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return 0;
    }

    //Brute force
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    //     int m = nums1.length + nums2.length;
    //     int[] number = new int[m];
    //     int i = 0;
    //     int j = 0, k = 0;

    //     while(i < nums1.length && j < nums2.length){
    //         if(nums1[i]<nums2[j])
    //             number[k++] = nums1[i++];
    //         else
    //             number[k++] = nums2[j++];
    //     }

    //     while(i < nums1.length)
    //         number[k++] = nums1[i++];

    //     while(j < nums2.length)
    //         number[k++] = nums2[j++];

    //     int length = number.length;
    //     int n = length / 2;

    //     if(length % 2 == 0)
    //         return (double)(number[n] + number[n - 1]) / 2;

    //     return (double) number[n];
    // }
}

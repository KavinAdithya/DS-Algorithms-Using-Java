package com.techcrack.DSA.ArraysAndBS;

public class MedianSorted {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        int[] array = mergeArray(nums1, nums2);

        int length = array.length;

        if(length % 2 == 0){
            int mid = length / 2;
            return (array[mid] + array[mid - 1]) / 2.0;
        }
        return array[(int) length / 2];
    }

    private int[] mergeArray(int[] nums1, int[] nums2){
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length3 = length1 + length2;

        int[]  array = new int[length3];

        int i = 0, j = 0, k = 0;

        while(i < length1 && j < length2){

            if(nums1[i] < nums2[j])
                array[k++] = nums1[i++];
            else
                array[k++] = nums2[j++];

        }

        while(i < length1)
            array[k++] = nums1[i++];

        while(j < length2)
            array[k++] = nums2[j++];

        return array;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;

        if(l1 > l2)
            return findMedianSortedArrays(nums2, nums1);

        int mid = (l1 + l2 + 1) / 2;

        return findMedian(l1, l2, nums1, nums2, mid);
    }

    private double findMedian(int length1, int length2, int[] array1, int[] array2, int count){
        int start = 0;
        int end = length1;

        boolean odd = (length1 + length2 ) % 2 != 0;

        while(start <= end){
            int mid1 = (start + end) / 2;
            int mid2 = count - mid1;

            int topLeft = mid1 > 0 ? topLeft = array1[mid1 - 1] :  Integer.MIN_VALUE;
            int topRight = mid1  < length1 ? topRight = array1[mid1] : Integer.MAX_VALUE;
            int bottomLeft = mid2 > 0 ? bottomLeft =  array2[mid2 - 1] : Integer.MIN_VALUE;
            int bottomRight = mid2  < length2 ?  bottomRight = array2[mid2] : Integer.MAX_VALUE;

            if(topLeft <= bottomRight && bottomLeft <= topRight){
                int a1 = topLeft > bottomLeft ? topLeft : bottomLeft;
                int a2 = topRight > bottomRight ? bottomRight : topRight;

                if(odd)
                    return (double)a1;
                return (a1 + a2) / 2.0;
            }
            else if(topLeft > bottomRight)
                end = mid1 - 1;
            else
                start = mid1 + 1;
        }

        return 0.0;
    }
}

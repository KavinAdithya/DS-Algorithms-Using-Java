package com.techcrack.dsa.arrayBinarySearch;

public class UniqueAdd {
    /*
     *N value has been given to you needed to
     * return array which sum of array =0 and size of array is n
     */
    public int[] sumZero(int n) {
        int[] array = new int[n];

        int mid = n / 2;
        int left = mid-1;
        int right = mid ;
        if (n % 2 != 0) {
            array[mid] = 0;
            left = mid-1;
            right = mid + 1;
        }

        int k = 1;
        while (left >= 0) {
            array[left] = k * -1;
            array[right] = k;
            k++;
            left--;
            right++;
        }
        return array;
    }

    public int[] sumZero1(int n){
        int[] array=new int[n];
        int sum=0;
        int m=1;
        for(int k=0;k<n-1;k++){
            array[k]=m;
            sum+=m;
            m++;
        }
        array[n-1]=sum*-1;
        return array;
    }
}
package com.techcrack.DSA.ArrayBinarySearch;
 public class FirstMissingPositive {
    public int firstMissingPositive(int[] numb) {

        int length = numb.length;
        int k = 0;

        while(k < length){
            if(numb[k] > 0 && numb[k] < length && numb[k] != numb[numb[k] - 1]){
                int temp = numb[k];
                numb[k] = numb[numb[k] - 1];
                numb[temp - 1] = temp;
            }
            else
                k++;
        }

        for(int d = 0; d  < length; d++){
            if(numb[d] != d + 1)
                return ++d;
        }

        return ++length;
    }

    // BRUTE fORCE
    //public int firstMissingPositive(int[] nums) {
    //     HashSet<Long> list = new HashSet<>();

    //     for(int m : nums)
    //         list.add((long)m);

    //     for(long k = 1; k <= nums.length + 1; k++){
    //         if(! list.contains(k))
    //             return (int) k;
    //     }
    //     return -1;
    // }
}
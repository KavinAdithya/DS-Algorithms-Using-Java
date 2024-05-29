package com.techcrack.DSA.ArraysAndBS;

public class FindDuplicatesWithoutUsingConstantSpace {
    //Range Values Algorithm
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int ans = Math.abs(num);
            if (nums[ans] < 0)
                return ans;
            nums[ans] *= -1;
        }
        return -1;
    }


//floyd's cycle algorithm

//  public int findDuplicate(int[] nums) {
//     int slow = nums[0];
//     int fast = nums[0];

//     do{
//         slow = nums[slow];
//         fast = nums[nums[fast]];
//     }while(slow != fast);

//     slow = nums[0];

//     while(slow !=  fast){
//         slow = nums[slow];
//         fast = nums[fast];
//     }

//     return fast;
// }

// Binary Search

// public int findDuplicate(int[] nums) {
//     int start = 1;
//     int end = nums.length;

//     while(start < end){

//         int mid = (start + end) / 2;
//         int count = 0;

//         for(int k : nums){
//             if(k <= mid)
//                 count++;
//         }

//         if(count > mid)
//             end = mid;
//         else
//             start = mid + 1;

//     }

//     return start;
// }

//Hash Table Method

// public int findDuplicate(int[] nums) {
//     int[] array = new int[nums.length];
//     for(int k : nums){
//         array[nums[k]]++;
//         if(array[k] > 1)
//             return k;
//     }
//     return -1;
// }

//Bit wise manipulation
// public int findDuplicate(int[] nums) {
//    int answer =  0;

//    for(int k = 0; k < 32; k++){
//         int mask = 1 << k;
//         int a = 0, b = 0;

//         for(int d =  0; d < nums.length; d++){
//             if((d & mask) > 0)
//                 b++;
//             if((nums[d] & mask) > 0)
//                 a++;
//         }

//         if( a > b)
//             answer = answer | mask;
//    }

//    return answer;
// }}
}
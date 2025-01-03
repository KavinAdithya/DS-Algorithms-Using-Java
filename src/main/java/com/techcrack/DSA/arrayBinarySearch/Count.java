package com.techcrack.DSA.arrayBinarySearch;

import java.util.*;
public class Count {

    // Brute Force
    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;

        List<Integer> list = new ArrayList<>();

        for(int k = 0; k < length; k++){
            int count = 0;

            for(int d = k + 1; d < length; d++){
                if(nums[k] > nums[d])
                    count++;
            }

            list.add(count);
        }

        return list;
    }


    //Binary Search Solution
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> hashing = new ArrayList<>();

        for(int num : nums)
            hashing.add(num);

        Collections.sort(hashing);

        for(int k = 0; k < nums.length; k++){
            int index = searchIt(nums[k], hashing);

            result.add(index);
            hashing.remove(index);
        }

        return result;
    }


    private int searchIt(int target, List<Integer> list){
        int start = 0;
        int end = list.size() - 1;

        while(start < end){
            int mid = (start + end) / 2;

            if(list.get(mid) >= target)
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }

    //Fenwick Tree O(nlog(n))
    public List<Integer> countSmaller3(int[] nums) {
        int length = nums.length;

        int[][] mapping = new int[length][2];

        for(int k = 0; k < length; k++){
            mapping[k][0] = nums[k];
            mapping[k][1] = k;
        }

        Arrays.sort(mapping, ((a, b) -> a[0] - b[0]));

        Integer[] result = new Integer[length];

        int[] rangeSum = new int[length + 1];

        for(int k = 0; k < nums.length; k++){
            update(mapping[k][1] + 1, rangeSum);

            int count = query(length, rangeSum) - query(mapping[k][1] + 1, rangeSum);
            result[mapping[k][1]] = count;
        }

        return Arrays.asList(result);
    }

    private int query(int id, int[] rangeSum){
        int sum = 0;

        while( id > 0){
            sum += rangeSum[id];
            id -= (id & -id);
        }

        return sum;
    }

    private void update(int id, int[] rangeSum){
        while(id < rangeSum.length){
            rangeSum[id] += 1;
            id += (id & -id);
        }
    }
}

package com.techcrack.DSA.arrayBinarySearch;

import java.util.*;

public class CountSelf {
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> hashing = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            hashing.add(nums[i]);
        }

        // Comparator<int[]> comparator = (a, b) -> a[0] - b[0];
        Collections.sort(hashing);

        Integer[] result = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int index = count(hashing,  nums[i]);
            hashing.remove(index);
            result[i] = index;
        }

        return Arrays.asList(result);
    }

    public int count(List<Integer> hashing, int target) {
        int start = 0;
        int end = hashing.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            int midValue = hashing.get(mid);

            if (midValue >= target)
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }


    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;

        int[] prefixSum = new int[length + 1];

        List<int[]> sortSolution = new ArrayList<>();

        for (int i = 0; i < length; i++)
            sortSolution.add( new int[]{nums[i], i});

        Comparator<int[]> comparator = (a, b) -> a[0] - b[0];
        Integer[] result = new Integer[length];
        Collections.sort(sortSolution, comparator);


        for (int[] ss : sortSolution) {

            update(prefixSum, ss[1] + 1);
            result[ss[1]] = query(prefixSum, length) - query(prefixSum, ss[1] + 1);
        }

        return Arrays.asList(result);
    }

    public void update(int[] prefixSum, int index) {
        while (index < prefixSum.length) {
            prefixSum[index] += 1;
            index += (index & -index);
        }
    }

    public int query(int[] prefixSum, int index) {
        int sum = 0;
        while (index > 0) {
            sum += prefixSum[index];
            index -= (index & -index);
        }

        return sum;
    }
}

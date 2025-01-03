package com.techcrack.DSA.sorting;

import java.util.*;

class SortIntegerBy1Bits {
    public int[] sortByBits1(int[] arr) {
        Map<Integer, List<Integer>> bitsCount = new HashMap<>();

        int maxBit = 0;

        for (int a : arr) {
            int bits = findOnesBits1(a);

            if (bits > maxBit)
                maxBit = bits;
            
            if (! bitsCount.containsKey(bits))
                bitsCount.put(bits, new ArrayList<>());

            bitsCount.get(bits).add(a);
        }

        int index = 0;

        for (int i = 0; i <= maxBit; i++) {
            if (! bitsCount.containsKey(i))
                continue;
            
            List<Integer> values = bitsCount.get(i);
            Collections.sort(values);

            for (int val : values) {
                arr[index] = val;
                index++;
            }
        }

        return arr;
    }

    private int findOnesBits1(int value) {
        int ones = 0;

        while (value > 0) {
            if (value % 2 == 1) 
                ones++;
            value /= 2;
        }

        return ones;
    }

    public int[] sortByBits2(int[] arr) {
        Map<Integer, List<Integer>> bitsCount = new TreeMap<>();

        for (int a : arr) {
            // int bits = Integer.bitCount(a);
            int bits = findOnesBits2(a);
            bitsCount.computeIfAbsent(bits, k -> new ArrayList<>()).add(a);
        }

        int index = 0;

        for (List<Integer> values : bitsCount.values()) {
            Collections.sort(values);

            for (int val : values) {
                arr[index] = val;
                index++;
            }
        }

        return arr;
    }

    private int findOnesBits2(int value) {
        int ones = 0;

        while (value > 0) {
            if ((value & 1) == 1)
                ones++;
            value >>= 1;
        }

        return ones;
    }

    public int[] sortByBits3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + Integer.bitCount(arr[i]) * 10001;
        }

        Arrays.sort(arr);

        for (int i= 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10001;
        }

        return arr;
    }

    public int[] sortByBits(int[] arr) {
        Integer[] boxedArr = Arrays.stream(arr)
                .boxed()
                .toArray(Integer[] :: new);
        Arrays.sort(boxedArr, (a, b) -> {
            int aBits = Integer.bitCount(a);
            int bBits = Integer.bitCount(b);

            if (aBits == bBits)
                return Integer.compare(a, b);
            return Integer.compare(aBits, bBits);
        });

        return Arrays.stream(boxedArr)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
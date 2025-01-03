package com.techcrack.DSA.algorithms;

public class HareTortoiseAlgorithm {

    static int findDuplicates(int[] arr) {
        int hare = arr[0];
        int tortoise = arr[arr[0]];

        while (hare != tortoise) {
            hare = arr[hare];
            tortoise = arr[arr[tortoise]];
        }

        hare = arr[0];

        while (hare != tortoise) {
            hare = arr[hare];
            tortoise = arr[tortoise];
        }

//        Arrays.sort(new int[]{1, 2,3, 4}, ((a,b) -> Integer.compare((Integer) a, b))) ;
        return hare;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 6};
        System.out.println(findDuplicates(arr));
    }
}

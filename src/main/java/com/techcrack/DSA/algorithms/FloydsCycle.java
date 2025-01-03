package com.techcrack.DSA.algorithms;

public class FloydsCycle {

    private static int findDuplicates(int[] array) {
        int hare = array[0];
        int tortoise = array[0];

        do { 
            hare = array[array[hare]];
            tortoise = array[tortoise];
        } while (hare != tortoise);

        hare = array[0];
        while (hare != tortoise) {
            hare = array[hare];
            tortoise = array[tortoise];
        }

        return array[hare];
    }


    public static void main(String[] args) {
        int[] array = {10, 1, 2, 3, 5, 4, 9, 8, 5, 6, 4};
        System.out.println(findDuplicates(array));
    }
    
}
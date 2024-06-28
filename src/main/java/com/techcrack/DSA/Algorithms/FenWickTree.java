package com.techcrack.DSA.Algorithms;

public class FenWickTree {
    public static int rangeSum(int[] array, int start, int end){
        int[] sumArray = new int[array.length + 1];

        for(int k = 0; k < array.length; k++)
            update(sumArray, k + 1, array[k]);

        int left = findRange(sumArray, start);
        int right = findRange(sumArray,end + 1);

        return right - left;
    }

    private static void update(int[] sumArray, int index, int value){
        while(index < sumArray.length){
            sumArray[index] += value;
            index += (index & -index);
        }
    }

    private static int findRange(int[] sumArray, int end){
        int sum = 0;

        while(end > 0){
            sum += sumArray[end];
            end -= (end & -end);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 2, -1, 6, 5, 4, -2, 3};
        System.out.println(rangeSum(array, 4, 6));
    }
}

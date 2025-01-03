package com.techcrack.DSA.strings;

class OperationSorted {
    public int makeStringSorted(String s) {
        boolean isNotSorted = true;
        char[] sArray = s.toCharArray();
        long operation = 0;

        if (isSorted(sArray))
            return 0;

        while (isNotSorted) {
            int i = findLargestIndex(sArray);
            int j = findSecondLargestIndex(sArray, i - 1);

            swap(sArray, i - 1, j);
            reverse(sArray, i);

            if (isSorted(sArray))
                isNotSorted = false;
            
            operation++;
        }

        return (int)(operation % 1_000_000_007);
    }


    private int findLargestIndex(char[] sArray) {
        int length = sArray.length - 1;

        for (int i = length; i > 0; i--) {
            if (sArray[i] < sArray[i - 1])
                return i;
        }

        return 0;
    }

    private int findSecondLargestIndex(char[] sArray, int targetIndex) {
        int length = sArray.length - 1;

        for (int i = length; i > targetIndex; i--) {
            if (sArray[i] < sArray[targetIndex])
                return i;
        }

        return targetIndex + 1;
    }

    private void swap(char[] sArray, int start, int end) {
        char temp = sArray[start];
        sArray[start] = sArray[end];
        sArray[end] = temp;
    }

    private void reverse(char[] sArray, int start) {
        int end = sArray.length - 1;

        while (start < end) {
            swap(sArray, start, end);
            start++;
            end--;
        }
    }

    private boolean isSorted(char[] sArray) {
        int length = sArray.length - 1;

        for (int i = 0; i < length; i++) {
            if (sArray[i] > sArray[i + 1])
                return false;
        }

        return true;
    }
}
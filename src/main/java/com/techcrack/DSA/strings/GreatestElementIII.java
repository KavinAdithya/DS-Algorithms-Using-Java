package com.techcrack.DSA.strings;

import java.util.Arrays;

public class GreatestElementIII {
    public int nextGreaterElement3(int n) {
        String s = String.valueOf(n);

        int[] digitsArray = new int[s.length()];


        int i = 0;
        for (char ch : s.toCharArray())
            digitsArray[i++] = ch - '0';

        int length = digitsArray.length;

        if (length == 1)
            return -1;

        int startIndex = length - 2;

        while (startIndex > 0) {
            if (digitsArray[startIndex] < digitsArray[startIndex + 1])
                break;
            startIndex--;
        }

        int endIndex = length - 1;
        int smallIndex = startIndex + 1;


        while (endIndex > startIndex) {
            if (digitsArray[endIndex] <= digitsArray[smallIndex] && digitsArray[endIndex] > digitsArray[startIndex]) {
                smallIndex = endIndex;

            }
            endIndex--;
        }


        swap(digitsArray, startIndex, smallIndex);


        sort(digitsArray, startIndex + 1, length - 1);



        long answer = 0;

        for (int digit : digitsArray)
            answer = (answer * 10) + digit;


        if ( answer > Integer.MAX_VALUE || answer <= n)
            return -1;
        return (int)answer;
    }

    public void swap(int[] digitsArray, int startIndex, int endIndex) {
        int temp = digitsArray[startIndex];
        digitsArray[startIndex] = digitsArray[endIndex];
        digitsArray[endIndex] = temp;
    }

    public void sort(int[] array, int startIndex, int endIndex) {
        int[] a1 = new int[endIndex - startIndex + 1];
        for (int i = 0; i < a1.length; i++)
            a1[i] = array[i + startIndex];
        Arrays.sort(a1);

        for (int i = startIndex; i < endIndex + 1; i++)
            array[i] = a1[i - startIndex];
    }

    public int nextGreaterElement1(int n) {
        int[] digits = integerToArray(n);
        int startIndex = startingPointer(digits);

        if (startIndex == -1)
            return -1;

        int endIndex = binarySearch(digits, startIndex + 1, digits.length - 1, digits[startIndex]);

        int temp = digits[startIndex];
        digits[startIndex] = digits[endIndex];
        digits[endIndex] = temp;

        reverseSort(digits, startIndex + 1, digits.length - 1);

        long answer = 0;

        for (int digit : digits)
            answer = (answer * 10 ) + digit;

        if (answer > Integer.MAX_VALUE || answer <= n)
            return -1;

        return (int) answer;
    }

    public int[] integerToArray(int n) {
        int digitCount = countDigits(n);

        int[] digits = new int[digitCount];

        int i = digitCount - 1;

        while (n > 0) {
            digits[i] = n % 10;
            n /= 10;
            i--;
        }

        return digits;
    }

    public int countDigits(int n) {
        int count = 0;

        while (n > 0) {
            count++;
            n /= 10;
        }

        return count;
    }

    public int binarySearch(int[] digits, int start, int end, int target) {
        int answer = end ;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (digits[mid] <= target)
                end = mid - 1;
            else {
                answer = mid;
                start = mid + 1;
            }

        }

        return answer;
    }

    public void reverseSort(int[] digits, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            int temp = digits[leftPointer];
            digits[leftPointer] = digits[rightPointer];
            digits[rightPointer] = temp;

            leftPointer++;
            rightPointer--;
        }
    }

    public int startingPointer(int[] digits) {
        int length = digits.length - 2;

        while (length >= 0 ) {
            if (digits[length] < digits[length + 1])
                return length;
            length--;
        }

        return length;
    }


    public int nextGreaterElement(int n) {
        int[] digitArray = divideDigitArray(n);

        int findSwappedIndex = findCorrectIndexSwap(digitArray);

        sortArray(digitArray, findSwappedIndex );

        long answer = convertIntoLong(digitArray);



        if (Integer.MAX_VALUE < answer || answer <= n)
            return -1;
        return (int)answer;
    }

    public int[] divideDigitArray(int n) {
        String s = String.valueOf(n);

        int[] digitArray = new int[s.length()];

        for (int i = 0; i < s.length(); i++)
            digitArray[i] = s.charAt(i) - '0';

        return digitArray;
    }

    public int findCorrectIndexSwap(int[] digitArray) {

        for (int i = digitArray.length - 1; i > 0; i--) {
            if (digitArray[i] > digitArray[i - 1]) {
                swap(digitArray, i - 1);
                return i;
            }
        }

        return 0;
    }

    public void swap(int[] digitArray, int source) {

        int destination = findAnyOther(digitArray, source);

        digitArray[source] = digitArray[source] ^ digitArray[destination];
        digitArray[destination] = digitArray[source] ^ digitArray[destination];
        digitArray[source] = digitArray[source] ^ digitArray[destination];
    }

    public int findAnyOther(int[] digitArray, int targetIndex) {
        int target = digitArray[targetIndex];
        int index = targetIndex + 1;

        for (int i = targetIndex + 1; i < digitArray.length; i++) {
            if (digitArray[index] > digitArray[i] && digitArray[i] > target)
                index = i;
        }

        return index;
    }

    public void sortArray(int[] digitArray, int startingIndex) {
        int length = digitArray.length;

        int[] dup = new int[length - startingIndex];

        for (int i = 0; i < dup.length; i++) {
            dup[i] = digitArray[i + startingIndex];
        }

        Arrays.sort(dup);

        for (int i = 0; i < dup.length; i++)
            digitArray[i + startingIndex] = dup[i];
    }

    public long convertIntoLong(int[] digitArray) {
        long result = 0;

        for (int digit : digitArray)
            result = result * 10 + digit;
        return result;
    }
}

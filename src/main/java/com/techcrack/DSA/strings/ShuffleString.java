package com.techcrack.DSA.strings;

public class ShuffleString {

    // Hashing
    public String restoreString1(String s, int[] indices) {
        int length = indices.length;

        char[] hashing = new char[length];

        int stringPointer = 0;
        for (int index : indices){
            hashing[index] = s.charAt(stringPointer);
            stringPointer++;
        }

        StringBuilder shuffledString = new StringBuilder();

        for (char ch : hashing)
            shuffledString.append(ch);

        return shuffledString.toString();
    }

    // Cyclic sort
    public String restoreString(String s, int[] indices) {
        char[] hashed = cyclicSort(s, indices);

        return new String(hashed);
    }

    public char[] cyclicSort(String s, int[] indices) {
        int length = indices.length ;
        int start = 0;
        char[] hashing = s.toCharArray();

        while (start < length) {
            if (start == indices[start])
                start++;
            else{
                swap(hashing, start, indices[start]);
                swap(indices, start, indices[start]);
            }
        }

        return hashing;
    }

    public void swap(int[] indices, int start, int end){
        int temp = indices[start];
        indices[start] = indices[end];
        indices[end] = temp;
    }

    public void swap(char[] indices, int start, int end) {
        char temp = indices[start];
        indices[start] = indices[end];
        indices[end] = temp;
    }


    public String restoreString3(String s, int[] indices) {
        int length = indices.length;

        char[] hashing = new char[length];

        int stringPointer = 0;
        for (int index : indices){
            hashing[index] = s.charAt(stringPointer);
            stringPointer++;
        }


        return new String(hashing);
    }
}

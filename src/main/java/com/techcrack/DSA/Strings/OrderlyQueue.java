package com.techcrack.DSA.Strings;

import java.util.*;

class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        int length = s.length();
        List<List<Object>> pairElement = new ArrayList<>();


        for (int i = 0; i < length; i++) {
            pairElement.add(new ArrayList<>());
            pairElement.get(i).add(s.charAt(i));
            pairElement.get(i).add(i);
        }

        Comparator<List<Object>> comparator = (a, b) -> (Character)a.get(0) - (Character)b.get(0);

        pairElement.sort(comparator);

        Set<Integer> hashing = new HashSet<>();
        char[] rotatedElement = new char[length];

        for (int i = 0; i < k; i++) {
            List<Object> list = pairElement.get(i);
            rotatedElement[i] = (char)list.get(0);
            hashing.add((int)list.get(1));
        }

        int aPointer = k;
        int sPointer = k;

        while (sPointer < length) {
            if ( ! hashing.contains(sPointer)) {
                rotatedElement[aPointer] = s.charAt(sPointer);
                aPointer++;
            }

            sPointer++;
        }
        sPointer = 0;
        
        while (sPointer  < k) {
            if (! hashing.contains(sPointer)) {
                rotatedElement[aPointer] = s.charAt(sPointer);
                aPointer++;
            }
            sPointer++;
        }

        return new String(rotatedElement);
    }


    // Working Solution
    public String orderlyQueue1(String s, int k) {
        char[] sArray = s.toCharArray();

        if (k > 1) {
            Arrays.sort(sArray);
            return new String(sArray);
        }

        StringBuilder rotatedString = new StringBuilder(s);
        for (int i = 0; i < sArray.length; i++) {
            char ch = rotatedString.charAt(0);
            rotatedString.deleteCharAt(0);
            rotatedString.append(ch);


            if (s.compareTo(rotatedString.toString()) > 0)
                s = rotatedString.toString();

        }

        return s;
    }
}
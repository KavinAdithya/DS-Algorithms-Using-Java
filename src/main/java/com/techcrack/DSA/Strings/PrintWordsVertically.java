package com.techcrack.DSA.Strings;

import java.util.ArrayList;
import java.util.List;

class PrintWordsVertically {
    public List<String> printVertically(String s) {
        String[] sArray = s.split(" ");

        int length = 0;

        for (String ss : sArray) {
            if (ss.length() > length)
                length = ss.length();
        }

        return createVerticalList(sArray, length);
    }

    private List<String> createVerticalList(String[] sArray, int length) {
        StringBuilder[] vertical = new StringBuilder[length];

        int i = 0;

        while (i < length) {
            vertical[i] = new StringBuilder();

            for (String s : sArray) {
                if (i < s.length())
                    vertical[i].append(s.charAt(i));
                else
                    vertical[i].append(" ");

            }

            i++;
        }

        for (StringBuilder v : vertical) {
            int length1 = v.length() - 1;

            while (length1 > -1 && v.charAt(length1) == ' ')
                v.deleteCharAt(length1--);
            
        }

        List<String> verticalList = new ArrayList<>();

        for (StringBuilder v : vertical) {
            verticalList.add(v.toString());
        }

        return verticalList;
    }
}
package com.techcrack.dsa.strings;

import java.util.*;

class TransformableSortSubstring {
    public boolean isTransformable(String s, String t) {
        List<Deque<Integer>> positions = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            positions.add(new ArrayDeque<>());
        }

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            positions.get(digit).add(i);
        }


        for (int i = 0; i < t.length(); i++) {
            int targetElement = t.charAt(i) - '0';

            if (positions.get(targetElement).isEmpty())
                return false;
            
            int currentIndex = positions.get(targetElement).peek();

            for (int j = 0; j < targetElement; j++) {
                if (! positions.get(j).isEmpty() && positions.get(j).peek() < currentIndex)
                    return false;
            }

            positions.get(targetElement).poll();
        }


        return true;
    }
}
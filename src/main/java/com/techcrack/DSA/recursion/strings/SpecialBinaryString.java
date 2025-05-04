package com.techcrack.dsa.recursion.strings;

import java.util.*;

class SpecialBinaryString {
    public String makeLargestSpecial(String s) {
        List<String> substrings = new ArrayList<>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            if (count == 0) {
                // Recursively process the middle part
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                substrings.add("1" + inner + "0");
                start = i + 1;
            }
        }

        // Sort in reverse lexicographical order
        substrings.sort(Comparator.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String sub : substrings) {
            result.append(sub);
        }

        return result.toString();
    }
}

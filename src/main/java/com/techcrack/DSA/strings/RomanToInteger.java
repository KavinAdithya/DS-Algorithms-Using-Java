package com.techcrack.DSA.strings;

import java.util.*;
class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> symbols = new HashMap<>();

        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);

        int romanInteger = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int currentValue = symbols.get(s.charAt(i));
            int nextValue = i + 1 < length ? symbols.get(s.charAt(i + 1)) : 0;

            if (currentValue < nextValue) {
                romanInteger += (nextValue - currentValue);
                i++;
            }
            else
                romanInteger += currentValue;

        }

        return romanInteger;
    }


    class Solution {
        public int romanToInt(String s) {
            int ans = 0;

            for (int i = s.length() - 1; i > - 1; i--) {
                char ch = s.charAt(i);

                int nums = switch(ch) {
                    case 'I' -> 1;
                    case 'V' -> 5;
                    case 'X' -> 10;
                    case 'L' -> 50;
                    case 'C' -> 100;
                    case 'D' -> 500;
                    default -> 1000;
                };

                ans += nums * 4 > ans ? nums : -nums;
            }

            return ans;
        }
    }
}
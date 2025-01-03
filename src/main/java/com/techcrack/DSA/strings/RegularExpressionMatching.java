package com.techcrack.DSA.strings;

import java.util.HashMap;
import java.util.Map;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isPatternMatches(s, p, s.length() - 1, p.length() - 1);        
    }


    private boolean isPatternMatches(String s, String p, int i, int j) {
        
        if (i < 0 && j < 0)
            return true;
        
        if (j < 0)
            return false;
        
         char ch1 = p.charAt(j);
        
        if (i < 0) {
        
            if (ch1 == '*')
                return isPatternMatches(s, p, i, j - 2);
            else
                return false;
        }
        char ch = s.charAt(i);

        if (ch1 == '*') {

            boolean res = false;
            if (p.charAt(j - 1) == ch || p.charAt(j - 1) == '.')
                res = res || isPatternMatches(s, p, i - 1, j);
            return res || isPatternMatches(s, p, i, j - 2);

        }


        if (ch1 == '.' || ch == ch1)
            return isPatternMatches(s, p, i - 1, j - 1);
        
        return false;        
    }

    class Brute {
        public boolean isMatch(String s, String p) {
            return isPatternValid(s, p, 0, 0);
        }


        private boolean isPatternValid(String s, String p, int i, int j) {
            int length1 = s.length();
            int length2 = p.length();

            if (i >= length1 && j >= length2)
                return true;

            if (j >= length2)
                return false;

            char ch = p.charAt(j);

            final boolean b = j + 1 < length2 && p.charAt(j + 1) == '*';
            if (i  >= length1) {
                if (b)
                    return isPatternValid(s, p, i, j + 2);
                else
                    return false;
            }

            char ch1 = s.charAt(i);

            if (b) {

                boolean result = false;
                if (ch == ch1 || ch == '.')
                    result = isPatternValid(s, p, i + 1, j);
                return result || isPatternValid(s, p, i, j + 2);
            }

            if (ch == ch1 || ch == '.')
                return isPatternValid(s, p, i + 1, j + 1);
            return false;
        }
    }
}

class DynamicApproachRegularExpression {

    private final Map<String, Boolean> map = new HashMap<>();

    public boolean isMatch(String text, String pattern) {
        return isMatchDP(0, 0, text, pattern);
    }

    private boolean isMatchDP(int i, int j, String text, String pattern) {
        String key = i + "," + j;

        if (map.containsKey(key))
            return map.get(key);

        if (j == pattern.length())
            return i == text.length();

        boolean firstMatch = i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');

        boolean answer;

        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*')
            answer = isMatchDP(i, j + 2, text, pattern) || (firstMatch && isMatchDP(i + 1, j, text, pattern));
        else
            answer = firstMatch && isMatchDP(i + 1, j + 1, text, pattern);

        map.put(key, answer);
        return answer;
    }
}
package com.techcrack.DSA.Strings;

import java.util.ArrayList;
import java.util.List;

class CamelCaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int length = queries.length;
        
        List<Boolean> patternMatch = new ArrayList<>(length);


        for (String query : queries) 
            patternMatch.add(isMatching(query, pattern));
        
        return patternMatch;
    }

    public boolean isMatching(String query, String pattern) {
        int queryPointer = 0;
        int patternPointer = 0;

        int length1 = query.length();
        int length2 = pattern.length();

        while (queryPointer < length1 && patternPointer < length2) {
            if (query.charAt(queryPointer) == pattern.charAt(patternPointer))
                patternPointer++;
            else {
                char ch = query.charAt(queryPointer);
                if (ch >= 'A' && ch <= 'Z')
                    return false;
            }

            queryPointer++;
        }

        while (queryPointer < length1) {
            char ch = query.charAt(queryPointer);

            if (ch >= 'A'  && ch <= 'Z')
                return false;
            queryPointer++;
        }

        return patternPointer == length2;
    }
}
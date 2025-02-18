package com.techcrack.dsa.sorting;

import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int n = strs.length;

        String[] anagram =  new String[n];

        for (int i = 0; i < n; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            anagram[i] = new String(array);      
        }


        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            
            if (isVisited[i])
                continue;
            
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            
            for (int j = i + 1; j < n; j++) {
                if (anagram[i].equals(anagram[j])) {
                    isVisited[j] = true;
                    list.add(strs[j]);
                }
            }
            
            isVisited[i] = true;
            result.add(list);
        }

        return result;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> storage = new HashMap<>();

        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);

            String a = String.valueOf(sArray);

            if (! storage.containsKey(a))
                storage.put(a, new ArrayList<String>());
            storage.get(a).add(s);
        }

        return new ArrayList<>(storage.values());
    }
}
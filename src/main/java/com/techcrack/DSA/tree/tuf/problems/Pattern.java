package com.techcrack.dsa.tree.tuf.problems;

import java.util.*;
class Pattern {
    public static void main(String[] args) {
        String a = "Supercalifragilisticexpialidocious";
        String b = "expect";
        int min = Integer.MAX_VALUE;
        String r = "";
        for(int i = 0; i < a.length(); i++)
        {
            String v = "";
            for(int j = i; j < a.length(); j++)
            {
                v+=a.charAt(j);

                Map<Character, Integer> vHash = new HashMap<>();

                for (int k = 0; k < v.length(); ++k) {
                    char ch = v.charAt(k);
                    vHash.put(ch, vHash.getOrDefault(ch, 0) + 1);
                }

                Map<Character, Integer> bHash = new HashMap<>();

                for (int k = 0; k < b.length(); ++k) {
                    char ch = b.charAt(k);
                    bHash.put(ch, bHash.getOrDefault(ch, 0) + 1);
                }

                boolean isNot = true;
                for (Character ch : bHash.keySet()) {
                    int c1 = vHash.getOrDefault(ch, 0);
                    int c2 = bHash.getOrDefault(ch, 0);

                    if (c1 != c2) {
                        isNot =  false;
                        break;
                    }
                }

                if (!isNot) {
                    if (min > v.length()) {
                        min = v.length();
                        r = v;
                    }
                }
            }
        }

        System.out.print(r);
    }
}
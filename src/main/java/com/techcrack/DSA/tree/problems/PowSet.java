package com.techcrack.dsa.tree.problems;

import java.util.*;

public class PowSet {
    public static void powSet(List<String> ans, String s, String cur, int idx) {
        if (! cur.isEmpty()) {
            ans.add(cur);
        }

        for (int i = idx; i < s.length(); ++i) {
            powSet(ans, s, cur + s.charAt(i), i + 1);
        }
    }

    public static void main(String[] args) {
        var list = new ArrayList<String>();

        powSet(list, "abc", "", 0);

        System.out.println(list);
    }
}

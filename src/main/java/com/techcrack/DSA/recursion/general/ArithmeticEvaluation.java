package com.techcrack.dsa.recursion.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticEvaluation {
    private static final char[] OPERATORS = {'+', '-', '*'};

    public static String arithmeticExpressions(List<Integer> arr) {

        List<String[]> res = evaluateExpression(arr, arr.size() - 1);

        for (String[] p : res) {
//            System.out.println(Arrays.toString(p));
            if (Integer.parseInt(p[1]) % 101 == 0) {
                System.out.println(p[1]);
                return p[0];
            }
        }

        return "";
    }

    public static List<String[]> evaluateExpression(List<Integer> arr, int index) {
        if (index == 0) {
            List<String[]> cur = new ArrayList<>();

            String val = "" + arr.get(index);
            cur.add(new String[]{val, val});

            return cur;
        }

        List<String[]> next = evaluateExpression(arr, index - 1);
        List<String[]> curAns = new ArrayList<>();

        for (String[] p : next) {
            String exp = p[0];
            int num = Integer.parseInt(p[1]);

            for (char op : OPERATORS) {
                String[] sa = new String[2];
                int val = arr.get(index);
                sa[0] = exp + op + val;
                sa[1] = "" + (op == '+' ? num + val : op == '-' ?  num - val:  num * val);

                curAns.add(sa);
            }
        }

        for (String[] p : curAns) {
            System.out.println(Arrays.toString(p));
        }

        return curAns;
    }


    public static String evalExp(List<Integer> arr, String ansStr, int ans, int index) {
        if (index == arr.size()) {
            return ans % 101 == 0 ? ansStr : "";
        }

        for (char op : OPERATORS) {
            String curStr = null;

            if (op == '+') {
                curStr = evalExp(arr, ansStr + op + arr.get(index), ans + arr.get(index), index + 1);
            }
            else if (op == '-') {
                curStr = evalExp(arr, ansStr + op + arr.get(index), ans - arr.get(index), index + 1);
            }
            else {
                curStr = evalExp(arr, ansStr + op + arr.get(index), ans * arr.get(index), index + 1);
            }

            if (!curStr.isEmpty()) {
                return curStr;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(55, 3, 45, 33, 25);

        System.out.println(arithmeticExpressions(arr));
    }
}

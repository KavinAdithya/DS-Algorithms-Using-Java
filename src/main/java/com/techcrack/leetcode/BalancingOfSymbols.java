package com.techcrack.leetcode;

import java.util.Stack;
public class BalancingOfSymbols {
    public static boolean balance(String s){
        Stack<Character> st=new Stack<>();
        for(Character ch:s.toCharArray()){
            if(ch=='('||ch=='['||ch=='{')
                st.push(ch);
            else if(st.isEmpty()||st.pop()==ch)
                return false;
            System.out.println(st);
        }
        // st.push('k');
        // st.push('l');
        // System.out.println(st.pop());
        return st.isEmpty();
    }
    public static void main(String[] args){
        System.out.println(balance("(a{}{}[]"));
    }
}

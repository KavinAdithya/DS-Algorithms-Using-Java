package com.techcrack.dsa.recursion.backtrack.maze;/*package whatever //do not write package name here */

import java.util.ArrayList;
import java.util.List;

class PalindromeSubstring {

    //funtion to check whether partitioned string is palindrome or not
    public boolean checkPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }

    // Recursive funtion which takes index ind and generates all substrings starting at ind.
    // if substring generated is palindrome it adds to current list and makes a recursive call for remaining string

    public void partition(ArrayList<ArrayList<String>> res, String s, int ind, ArrayList<String> curr) {
        // if we reach the end of string
        // add the current list to the result

        if(ind == s.length()) {
            res.add(new ArrayList<String>(curr));
            return;
        }

        // Store the current substring
        String temp = "";

        for(int i = ind; i < s.length(); i++) {
            temp += s.charAt(i);

            // check if string temp is palindrome or not
            if(checkPalindrome(temp)){

                // adds the string to current list
                curr.add(temp);

                // Recursive call for the remaining string
                partition(res, s, i+1, curr);

                // Remove the string from the current list - (backtracking)
                curr.remove(curr.size()-1);
            }
        }
        
    }


    public boolean isPalindrome(StringBuilder s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public void palindromePartition(List<List<String>> palindromes, List<String> curPalindrome, String s, int index) {
        if (s.length() == index) {
            palindromes.add(new ArrayList<>(curPalindrome));
            return;
        }

        StringBuilder str = new StringBuilder();

        for (int i = index; i < s.length(); ++i) {
            str.append(s.charAt(i));

            if (isPalindrome(str)) {
                curPalindrome.add(str.toString());

                palindromePartition(palindromes, curPalindrome, s, i + 1);

                curPalindrome.remove(curPalindrome.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromeSubstring obj = new PalindromeSubstring();

        List<List<String>> res = new ArrayList<>();
        
        String s = "nitin";

        int ind = 0;

        // Store the partition at current iteration
        ArrayList<String> curr = new ArrayList<>();

        // calling funtion to get partition
        obj.palindromePartition(res, curr, s, ind);

        for(List<String> iter : res) {
            System.out.println(iter);
        }
    }
}
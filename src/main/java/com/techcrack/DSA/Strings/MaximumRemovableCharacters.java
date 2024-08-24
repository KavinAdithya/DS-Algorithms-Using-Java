package com.techcrack.DSA.Strings;

class MaximumRemovableCharacters {

/* 
       *  @param s String where we remove characters
       *  This method removes the characters from the string and it again satisfy it as substring
       *  @param p substring
       *  @param int[] indices which are eligible for removing characters
       *  @return the k the element which means number of characters are removed but still it will stil satisfy the substring
       *  Using Binary Search algorithm to find the kth element 
*/
    public int maximumRemovals1(String s, String p, int[] removable) {
        
        // Start Index
        int start = 0;
        // End Index
        int end = removable.length - 1;

        // Searching in the range between start and end
        while (start <= end) {
            // Finding the Mid means K
            int mid = (start + end) / 2;

            // Inoking isSubstring method returns boolean value of true if it  has substring
            if (isSubString(s, p, removable, mid))
                start = mid + 1;
            else
                end = mid - 1;
        }

        // Returning the k th which is the answer
        return start; 
    }

/*
    * @param s String where we remove characters
    * @param p Substring
    * @param int[] removable index
    * @param k which is limit for removing characters from a array
    * @return true if it as a string of p
*/
    public boolean isSubString(String s, String p, int[] removable, int index) {
        // Storing the removed character indices
        boolean[] characterHashing = new boolean[s.length()];

        // Removing characters virtually
        for (int i = 0; i < index + 1; i++) 
     `01       characterHashing[removable[i]] = true;
        
        // Taking two pointers for pointing the two strings
        int i = 0;
        int j = 0;

        // Iterating the string unitll  the one string completely iterated
        while (i < s.length() && j < p.length()) {
            // Checking the characters present at s also present at p to ensure it forms substring
            if ( ! characterHashing[i] && s.charAt(i) == p.charAt(j))
                j++;
            i++;
        }

        // If the substring index reached end of index means s forms p as substring
        return j == p.length();
    }


    public int maximumRemovals(String s, String p, int[] removable) {
        int start = 1;
        int end = removable.length;
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isSubsequence(s, p, removable, mid)) {
                ans = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        return ans;
    }


    public boolean isSubsequence(String s, String p, int[] removable, int count) {
        boolean[] characterHashing = new boolean[s.length()];

        for (int i = 0; i < count; i++)
            characterHashing[removable[i]] = true;

        int i = 0;
        int j = 0;

        while (i < s.length() && j < p.length()) {
            if (! characterHashing[i] && s.charAt(i) == p.charAt(j))
                j++;
            i++;
        }

        return j == p.length();
    }

}
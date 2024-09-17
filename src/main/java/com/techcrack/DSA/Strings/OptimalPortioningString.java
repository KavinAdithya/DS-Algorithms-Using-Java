package com.techcrack.DSA.Strings;

class OptimalPortioningString {
    public int partitionString(String s) {
        int[] sHash = new int[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (sHash[ch - 'a'] != 0) {
                //fill(sHash);
                sHash = new int[26];
                count++;
            }

            sHash[ch - 'a']++;
        }

        return ++count;
    }

    private void fill(int[] sHash) {
        for (int i = 0; i < 26; i++)
            sHash[i] = 0;
    }
}
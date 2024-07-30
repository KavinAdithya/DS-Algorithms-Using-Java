package com.techcrack.DSA.Strings;

class RepeatingString {
    public int repeatedStringMatch(String a, String b) {
        boolean[] bucket = new boolean[26];

        for (char ch : a.toCharArray())
            bucket[ch - 'a'] = true;
        for (char ch : b.toCharArray())
            if (!bucket[ch - 'a'])
                return -1;
        int count = b.length() / a.length();

        StringBuilder s = new StringBuilder(a.repeat(count));

        for (int i = 0; i < 3; i++) {
            if (s.indexOf(b) != -1)
                return count + i;
            s.append(a);
        }

        return -1;
    }
    public int repeatedStringMatch1(String a, String b) {
        StringBuilder s = new StringBuilder(a);

        int count = 1;

        while (s.length() < b.length()) {
            s.append(a);
            count++;
        }

        if (s.indexOf(b) != -1)
            return count;
        
        s.append(a);
        count++;

        if (s.indexOf(b) != -1)
            return count;
        
        return -1;
    }
}
package com.techcrack.DSA.strings;

class RepeatingString {
    public int repeatedStringMatch2(String a, String b) {
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


    public int repeatedStringMatch3(String a, String b) {
        StringBuilder word1 = new StringBuilder();

        boolean[] bucket = new boolean[26];

        for (int i = 0; i < a.length(); i++)
            bucket[a.charAt(i) - 'a'] = true;

        for (int i = 0; i < b.length(); i++)
            if (! bucket[b.charAt(i) - 'a'])
                return -1;


        int length =  (int) Math.ceil( (double) b.length()  / a.length());
        int i = 0;

        while (i < length) {
            word1.append(a);
            //System.out.println(word1 + " " + word1.indexOf(b));

            if (word1.indexOf(b) != -1)
                return i + 1;
            i++;
        }

        word1.append(a);

        return word1.indexOf(b) != -1 ? i + 1 : -1;
    }


    public int repeatedStringMatch4(String a, String b) {
        boolean[] bucket = new boolean[26];

        for (char ch : a.toCharArray())
            bucket[ch - 'a'] = true;

        for (char ch : b.toCharArray()) {
            if (! bucket[ch - 'a'])
                return -1;
        }

        int length = b.length() / a.length();

        StringBuilder sb = new StringBuilder(a.repeat(length));

        for (int i = 0; i < 3; i ++) {
            if (sb.indexOf(b) != -1)
                return length + i;
            sb.append(a);
        }

        return -1;
    }

    public int repeatedStringMatch5(String a, String b) {
        int length1 = a.length();
        int length2 = b.length();

        int times = length2 / length1;

        StringBuilder repeatString = new StringBuilder();

        repeatString.append(a.repeat(times));


        for (int i = 0; i < 3; i++) {
            if (isEqual(repeatString, b))
                return times + i;
            repeatString.append(a);
        }

        return -1;
    }

    private boolean isEqual(StringBuilder rs, String s) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < s.length() && j < rs.length()) {
            if (rs.charAt(j) != s.charAt(i)) {
                i = -1;
                j =  k;
                k++;
            }
            i++;
            j++;
        }
        return i == s.length();
    }

    public int repeatedStringMatch6(String a, String b) {
        boolean[] bucket = new boolean[26];

        for (char ch : a.toCharArray())
            bucket[ch - 'a'] = true;

        for (char ch : b.toCharArray())
            if ( ! bucket[ch - 'a'])
                return -1;

        int times = b.length() / a.length();

        StringBuilder repeatString = new StringBuilder();

        for (int i = 0; i < times; i++)
            repeatString.append(a);


        for (int i = 0; i < 3; i++) {
            // if (isEqual(repeatString, b))

            if (repeatString.toString().contains(b))
                return times + i;
            repeatString.append(a);
        }

        return -1;
    }

}
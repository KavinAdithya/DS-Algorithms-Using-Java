package com.techcrack.dsa.recursion.subsets;

class StringDecode {
    public void decode(StringBuilder processed, String unprocessed, int index) {
        int num = 0;

        while (index < unprocessed.length() && unprocessed.charAt(index) != '[') {
            char ch = unprocessed.charAt(index);

            num = num * 10 + (ch - '0');
            index++;
        }

        System.out.println(num);

        index++;

        for (int i = 1; i <= num; i++) {
            int count = 1;
            int j = index;

            while (j < unprocessed.length() && count != 0) {
                char ch = unprocessed.charAt(j);
                char prevCh = j == 0 ? 'a' : unprocessed.charAt(j - 1);

                if (ch == '[') {
                    count++;
                }
                else if (ch == ']') {
                    count--;
                }
                else if (count == 1  && !(ch >= '0' && ch <= '9')) {
                    processed.append(ch);
                }
                else if (count == 1 && !(prevCh >= '0' && prevCh <= '9')) {
                    decode(processed, unprocessed, j);
                }

                j++;
            }
        }
    }

    
    public String decodeString(String s) {
        StringBuilder processed = new StringBuilder();
        int count =  0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char prevCh = i == 0 ? 'a' : s.charAt(i - 1);

            if (count == 0 && (i == 0 || ! Character.isDigit(prevCh)) && Character.isDigit(ch)) {
                decode(processed, s, i);
            }
            else if (ch == '[') {
                count++;
            }
            else if (ch == ']') {
                count--;
            }
            else if (count == 0 && ! Character.isDigit(prevCh)) {
                processed.append(ch);
            }
        }

        return processed.toString();
    }
}
package com.techcrack.DSA.Strings;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        

        int indexLength = 201;
        int index = 0;
        int i = 0;

        for (String str : strs) {
            if (indexLength > str.length()) {
                indexLength = str.length();
                index = i; 
            }
            i++;
        }

        String s = strs[index];

        for (i = 0; i < s.length(); i++) {

            for (String str : strs) {
                if (str.charAt(i) != s.charAt(i)) {
                    return s.substring(0, i);
                }
            }
        }

        return s;
    }


    public String longestCommonPrefix1(String[] strs) {
        StringBuilder s = new StringBuilder();
        if(strs.length > 1 && strs.length <= 200) {
            for(int k = 0; k < strs[0].length(); k++) {
                char ch = strs[0].charAt(k);
                int v = 1;
                while(v < strs.length && k < strs[v].length()){
                    if(strs[v].charAt(k) != ch)
                        return s.toString();
                    else if(v + 1 == strs.length){
                        s.append(ch);
                    }
                    v++;
                }
            }
        }
        else{
            return strs[0];
        }
        return s.toString();
    }
}
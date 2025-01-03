package com.techcrack.DSA.strings;

class AddBinary {
    public String addBinary(String a, String b) {
        int remainder = 0;
        StringBuilder addedBinary = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i > -1 || j > -1) {
            int a1 = i > -1 ? a.charAt(i) - '0' : 0;
            int b1 = j > -1 ? b.charAt(j) - '0' : 0;

            int c = a1 + b1 + remainder;

            if (c < 2) {
                remainder = 0;
                addedBinary.append(c);
            }
            else {
                remainder = 1;
                addedBinary.append(c % 2);
            }
             
            i--;
            j--;
        }

        if ( remainder == 1)
            addedBinary.append('1');

        return addedBinary.reverse().toString();
    }

    public String addBinary1(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();

        while ( i > - 1 || j > -1 || carry == 1) {
            if ( i > -1)
                carry += a.charAt(i--) - '0';
            if ( j > -1)
                carry += b.charAt(j--) - '0';

            result.append(carry % 2);
            carry /= 2;

        }

        return result.reverse().toString();
    }
}
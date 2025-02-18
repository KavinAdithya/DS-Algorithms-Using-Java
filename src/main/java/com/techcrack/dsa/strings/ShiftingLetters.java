package com.techcrack.dsa.strings;

class ShiftingLetters {
    public String shiftingLetters1(String s, int[] shifts) {
        int length = shifts.length;

        char[] result = s.toCharArray();

        long sumValue = 0;

        for (int i = length - 1; i > - 1; i--) {

            sumValue += shifts[i];

           result[i] = (char)  ((( (result[i] - 'a') + sumValue ) % 26) + 'a');
        }

        return String.valueOf(result);
    }

    public String shiftingLetters2(String s, int[] shifts) {
        int length = shifts.length;

        long[] moveEach = new long[length];
        moveEach[length - 1] = shifts[length - 1];

        for (int i = length - 2; i > -1; i--) {
            moveEach[i] = shifts[i] + moveEach[i + 1];
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            long charValue = (s.charAt(i) - 'a') + 1;

            long shift = moveEach[i] % 26;

            if (shift == 0)
                shift = 26;

            charValue += shift;

            charValue %= 26;

            if (charValue == 0)
                charValue = 26;

            result.append((char)(96 + charValue));
        }

        return result.toString();
    }


    public String shiftingLetters3(String s, int[] shifts) {
        int length = shifts.length;

        StringBuilder result = new StringBuilder();
        long sumValue = 0;

        for (int i = length - 1; i > - 1; i--) {

            sumValue += shifts[i];

            long charValue = (s.charAt(i) - 'a') + 1;

            long shift = sumValue % 26;

            if (shift == 0)
                shift = 26;

            charValue += shift;

            charValue %= 26;

            if (charValue == 0)
                charValue = 26;

            result.append((char)(96 + charValue));
        }

        return result.reverse().toString();
    }

    public String shiftingLetters(String s, int[] shifts) {
        int length = shifts.length;

        char[] sArray = s.toCharArray();
        long prefixSum = 0;

        for (int i = length - 1; i > -1; i--) {
            prefixSum += shifts[i];

            sArray[i] = (char) (((sArray[i] - 'a' + prefixSum) % 26) + 'a');
        }

        return new String(sArray);
    }

}
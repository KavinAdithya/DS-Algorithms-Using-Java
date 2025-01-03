package com.techcrack.DSA.strings;

class ExcelColumnTitle {
    public String convertToTitle1(int columnNumber) {
        StringBuilder result = new StringBuilder();
        columnTitle(columnNumber, result);
        return result.toString();
    }

    static void columnTitle(int columnNumber, StringBuilder result) {
     
        if (columnNumber < 27)
            result.append((char) (columnNumber + 64));
        else {
            
            int moduloValue = columnNumber % 26;
            if (moduloValue == 0) {
                moduloValue = 26;
                columnNumber--;
            }
            columnTitle(columnNumber / 26, result);
            result.append((char)(moduloValue + 64 ));
        }
    }


    static class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder result = new StringBuilder();
            columnTitle(columnNumber, result);
            return result.toString();
        }

        static void columnTitle(int columnNumber, StringBuilder result) {

            if (columnNumber < 27)
                result.append((char) (columnNumber + 64));
            else {

                int moduloValue = columnNumber % 26;
                if (moduloValue == 0) {
                    moduloValue = 26;
                    columnNumber--;
                }
                columnTitle(columnNumber / 26, result);
                result.append((char)(moduloValue + 64 ));
            }
        }
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;

            result.append((char)('A' + columnNumber % 26));

            columnNumber /= 26;
        }

        return result.reverse().toString();
    }
}
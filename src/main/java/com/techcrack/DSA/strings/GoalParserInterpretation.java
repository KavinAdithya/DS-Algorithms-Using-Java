package com.techcrack.DSA.strings;

public class GoalParserInterpretation {
    public String interpret(String command) {

        int i = 0;
        int commandLength = command.length();
        StringBuilder goalParser = new StringBuilder();

        while (i < commandLength) {
            if (command.charAt(i) == 'G') {
                goalParser.append('G');
                i += 1;
            }
            else if (command.charAt(i) == '(' && command.charAt( i + 1) == ')') {
                goalParser.append('o');
                i += 2;
            }
            else {
                goalParser.append("al");
                i += 4;
            }
        }

        return goalParser.toString();
    }
}

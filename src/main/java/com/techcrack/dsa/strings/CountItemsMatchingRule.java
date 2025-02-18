package com.techcrack.dsa.strings;

import java.util.List;

class CountItemsMatchingRule {
    public int countMatches1(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 2;

        if (ruleKey.equals("type"))
            index = 0;
        else if (ruleKey.equals("color"))
            index  = 1;
 
        return findCount(items, index, ruleValue);
        
    }

    public int findCount(List<List<String>> items, int index, String value) {
        int answer = 0;

        for (List<String> item : items) {
            if (item.get(index).equals(value))
                answer++;
        }

        return answer;
    }

    public int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
        int answer = 0;
        boolean type = false;
        boolean color = false;
        boolean name = false;

        if (ruleKey.equals("type"))
            type = true;
        else if (ruleKey.equals("color"))
            color = true;
        else
            name = true;


        for (List<String> item : items) {
            if (type && item.get(0).equals(ruleValue))
                answer++;
            else if (color && item.get(1).equals(ruleValue))
                answer++;
            else if (name && item.get(2).equals(ruleValue))
                answer++;
        }

        return answer;

    }

    public int countMatches4(List<List<String>> items, String ruleKey, String ruleValue) {
        int answer = 0;

        for (List<String> item : items) {
            if (ruleKey.equals("type") && item.get(0).equals(ruleValue))
                answer++;
            else if (ruleKey.equals("color") && item.get(1).equals(ruleValue))
                answer++;
            else if (ruleKey.equals("name") && item.get(2).equals(ruleValue))
                answer++;
        }

        return answer;

    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            default -> 2;
        };

        int itemMatch = 0;

        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue))
                itemMatch++;
        }

        return itemMatch;
    }
}
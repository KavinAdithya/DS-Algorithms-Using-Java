package com.techcrack.dsa.patterns;

import java.util.ArrayList;
import java.util.List;

class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 1; i < numRows + 1; i++) 
            pascalTriangle.add(generateRow(i));
        
        return pascalTriangle;
    }

    private List<Integer> generateRow(int row) {
        List<Integer> pascalRow = new ArrayList<>();
        pascalRow.add(1);

        int answer = 1;
        for (int i = 1; i < row - 1; i++) {
            answer = answer * (row - i) / i;
            pascalRow.add(answer);
        } 
        if (row != 1)
            pascalRow.add(1);
        return pascalRow;
    }
}
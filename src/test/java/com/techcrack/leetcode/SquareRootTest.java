package com.techcrack.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareRootTest {

    @Test
    void mainSquareRoot() {
        SquareRoot sr=new SquareRoot();
        assertEquals(12,sr.mainSquareRoot(144));
    }
}
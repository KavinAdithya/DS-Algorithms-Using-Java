package com.techcrack.DSA.lesson1;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @Test
    void leapYearTest(){


        int year = 16;
        LeapYear ly = new LeapYear();

        assertTrue(ly.checkLeapYear(year));
    }

}
package com.techcrack.DSA.lesson1;

public class LeapYear {
    public boolean checkLeapYear(int year){
        int checker = 0;

        if(year % 400 == 0)
            checker = 1;
        else if(year % 100 == 0) {
        }
        else if (year % 4 == 0)
            checker = 1;
        return checker == 1;
    }
}

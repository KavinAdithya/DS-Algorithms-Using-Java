package com.techcrack.dsa.recursion.subsets;

public class Dice {

    static void dice(String processed, int target) {
        if (target == 0) {
            System.out.println(processed);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(processed + i , target - i);
        }
    }

    public static void main(String[] args) {
        dice("", 4);
    }
}

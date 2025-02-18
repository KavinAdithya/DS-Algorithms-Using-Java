package com.techcrack.dsa.lesson1;

import java.util.Scanner;

public class TwoSum {
    //implementation of Sum
    public static void findSum(int a, int b){
        System.out.println("Sum of Two Sum is : " + (a + b));
    }

    //Driver Method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scan.nextLine());

        int secondNumber = Integer.parseInt(scan.nextLine());

        findSum(firstNumber, secondNumber);
    }
}

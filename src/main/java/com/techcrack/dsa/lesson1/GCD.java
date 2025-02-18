package com.techcrack.dsa.lesson1;

import java.util.Scanner;

public class GCD {

    //Method Is responsible for calculating GCD
    public static int findGCD(int firstNumber, int secondNumber){
        if(secondNumber == 0)
            return firstNumber;
        return findGCD(secondNumber, firstNumber % secondNumber);
    }

    //Method is responsible for calculating LCM
    public  static int findLCM(int firstNumber, int secondNumber){
        return (firstNumber * secondNumber) / findGCD(firstNumber, secondNumber);
    }

    //Driver Mode
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());

        int secondNumber = Integer.parseInt(scan.nextLine());

        System.out.println("LCM of "+ firstNumber + " and " + secondNumber + " is " + findLCM(firstNumber,  secondNumber));

        System.out.println("GCD of "+ firstNumber + " and " + secondNumber + " is " + findGCD(firstNumber,  secondNumber));
    }
}

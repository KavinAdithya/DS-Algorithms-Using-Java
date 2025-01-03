package com.techcrack.DSA.lesson2;

import java.util.Scanner;

public class SimpleAndCompound {

    //Method for calculating the simple interest
    private static double simpleInterest(double principalAmount, int rate, int time){
        return principalAmount * (rate / 100.0) * time;
    }

    //Method For Calculating the compound Interest
    private static double compoundInterest(double principalAmount, int rate, int time, int number){
        double rat = rate / 100.00;
        double amount = Math.pow(1 + rat / number, time * number);
        return amount * principalAmount;
    }

    //Driver Mode
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the details to find the Simple Interest.......");

        System.out.print("Enter Principal Amount : ");
        double principalAmount = scan.nextDouble();

        System.out.print("Enter the rate Of Interest : ");
        int rate = scan.nextInt();

        System.out.print("Enter the period Of Time : ");
        int time = scan.nextInt();

        System.out.println("Enter The Details to calculate the Compound Interest......");

        System.out.print("Enter the Principal Amount : ");
        double principalAmount1 = scan.nextDouble();

        System.out.print("Enter the rate Of Interest : ");
        int rate1 = scan.nextInt();

        System.out.print("Enter the time period Of re pay : ");
        int time1 = scan.nextInt();

        System.out.print("Enter the Number Of Time per Year : ");
        int year = scan.nextInt();

        System.out.println("Simple Interest of " + principalAmount + " for " + time + " years is : " + simpleInterest(principalAmount, rate, time));

        System.out.println("Compound Interest of " + principalAmount1 + " for "+ time1 + " years is : " + (compoundInterest(principalAmount, rate1, time1, year) - principalAmount1));
    }
}

package com.techcrack.DSA.Lesson2;

import java.util.Scanner;

public class ArithmeticOperation {
    public static double calculator(int a, char operation, int b){
        if(operation == '+')
            return a + b;
        else if(operation == '-')
            return  a - b;
        else if(operation == '*')
            return a * b;
        else if(operation == '/')
            return (double) a / b;
        else if(operation == '%')
            return a % b;
        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the First Number : ");
        int number1 = Integer.parseInt(scan.nextLine());

        System.out.print("Enter the Second Number : ");
        int number2 = Integer.parseInt(scan.nextLine());

        System.out.print("Enter Your Operation : ");
        char operation = scan.next().charAt(0);


        System.out.println("Answer for " + number1 + " and " + number2 + " is " + calculator(number1, operation, number2));
    }
}

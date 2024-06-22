package com.techcrack.DSA.Lesson2;

import java.util.Scanner;
public class MaxElement {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int number1 =  scan.nextInt();
        int number2 = scan.nextInt();

        System.out.println("Maximum Element Is : " + (Math.max(number1, number2)));
    }
}

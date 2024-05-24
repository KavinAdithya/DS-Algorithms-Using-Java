package com.techcrack.DSA.lesson1;

import java.util.Scanner;

public class SumOfALL {
    //Actual Code to Sum
    public static void sumOf(){

        Scanner scan = new Scanner(System.in);
        String ch = scan.nextLine();
        int sum = 0;

        while(!ch.equals("X")){
            sum += Integer.parseInt(ch);
            ch = scan.nextLine();
        }

        System.out.println("The Sum Of Number is : "+sum);
    }

    //Driver Code
    public static void main(String[] args) {
        sumOf();
    }
}

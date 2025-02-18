package com.techcrack.dsa.lesson2;

import java.util.Scanner;

public class OddOrEven {

    //We needed to find the given number is odd or even
    public static void main(String[] args){
        //Creating object for scanner class which is used to get input from user on console
        Scanner scan=new Scanner(System.in);

        int n=Integer.parseInt(scan.nextLine());

        if(n%2==0)
            System.out.println(n+" is Even.");
        else
            System.out.println(n+" is odd.");

    }
}

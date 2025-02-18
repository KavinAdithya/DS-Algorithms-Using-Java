package com.techcrack.dsa.lesson2;

import java.util.Scanner;
public class Currency {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Indian Rupees : " );
        double indianCurrency = scan.nextDouble();

        //System.out.println("Your "+ indianCurrency + " Indian Currency Is equal to $" + Math.round(indianCurrency / 82.56) + " U.S.Dollars !");
        System.out.format("Your %s Indian Currency Is equal to $%.2f U.S.Dollars !", indianCurrency, indianCurrency / 83.56);
    }
}

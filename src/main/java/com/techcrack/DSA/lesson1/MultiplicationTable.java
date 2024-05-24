package com.techcrack.DSA.lesson1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void printTable(int table, int range){

        for(int k = 1; k <= range; k++)
            System.out.println(k + " * " + table + " = " + (k * table));

    }

    //Driver mode '
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int table = Integer.parseInt(scan.nextLine());

        int range = Integer.parseInt(scan.nextLine());

        printTable(table, range);
    }
}

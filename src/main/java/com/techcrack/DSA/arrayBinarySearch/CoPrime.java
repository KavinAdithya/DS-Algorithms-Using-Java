package com.techcrack.DSA.arrayBinarySearch;
import java.util.Scanner;

public class CoPrime {
    private static int findGcd(int a, int b){
        if(a == 0)
            return b;
        else
            return findGcd(b % a , a);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        int count = 1;
        for(int k = 2; k < number; k++){
            if(findGcd(k, number) == 1)
                count++;
        }

        System.out.println(count);
    }
}

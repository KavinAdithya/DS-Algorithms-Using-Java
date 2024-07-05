package com.techcrack.DSA.Lesson3;

import java.util.Scanner;

public class FactorsOfANumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int k = 2; k <= n; k++)
            if(n % k == 0)
                System.out.print(k + " ");
    }
}

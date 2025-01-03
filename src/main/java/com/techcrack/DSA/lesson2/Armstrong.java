package com.techcrack.DSA.lesson2;
import java.util.Scanner;


public class Armstrong {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the starting point : ");
        int start = scanner.nextInt();

        System.out.print("Enter the End point : ");
        int end = scanner.nextInt();

        armStrong(start, end);
    }

    private static void armStrong(int start , int end){
        for(; start <= end; start++){
            if(checkIt(start))
                System.out.print(start + " ");
        }
    }

    private static boolean checkIt(int start){
        int count = countDigits(start);
        int copyStart = start;
        int sumStart = 0;

        while(start != 0){
            sumStart += (int)Math.pow(start % 10, count);
            start /= 10;
        }

        return sumStart == copyStart;
    }

    private static int countDigits(int start){
        int count = 0;
        while(start != 0){
            count++;
            start /= 10;
        }
        return count;
    }
}

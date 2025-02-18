package com.techcrack.dsa.lesson2;

import java.util.Scanner;

public class Palindromic {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("It is not a Case-Sensitive");
        System.out.print("Enter the String To check  : ");

        String string = scanner.nextLine();

        int stringLength = string.length();

        for(int k = 0; k < stringLength; k++){
            if(Character.toLowerCase(string.charAt(k)) != Character.toLowerCase(string.charAt(stringLength - 1 - k))){
                System.out.println(string + " String is not a palindrome ");
                return;
            }
        }

        System.out.println(string + " String is a palindrome");
    }
}

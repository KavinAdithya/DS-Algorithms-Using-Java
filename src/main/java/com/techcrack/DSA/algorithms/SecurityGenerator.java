package com.techcrack.dsa.algorithms;

import com.techcrack.dsa.recursion.practise.Solution;

import java.util.Scanner;

public class SecurityGenerator {
    public String encrypt(String data, String key) {
        StringBuilder encrypt = new StringBuilder();

        int add = key.charAt(2) - 'a' + 1;

        for (int i = 0; i < data.length(); ++i) {
            encrypt.append((char) (data.charAt(i) + add));
        }

        return encrypt.toString();
    }

    public String decrypt(String cipher, String key) {
        StringBuilder pass = new StringBuilder();

        int sub = key.charAt(2) - 'a' + 1;

        for (int i = 0; i < cipher.length(); ++i) {
            pass.append((char) (cipher.charAt(i) - sub));
        }

        return pass.toString();
    }

    public static void main(String[] args) {
        var encryptAlgo = new SecurityGenerator();
        var scan = new Scanner(System.in);

        System.out.print("Enter Word : ");
        String data =  scan.nextLine();

        System.out.print("Enter Domain Name : ");
        String domain = scan.nextLine().toLowerCase();

        System.out.print("Are You Want to Encrypt : ");
        System.out.println(scan.nextLine().equals("yes") ? encryptAlgo.encrypt(data, domain) : encryptAlgo.decrypt(data, domain));
    }
}

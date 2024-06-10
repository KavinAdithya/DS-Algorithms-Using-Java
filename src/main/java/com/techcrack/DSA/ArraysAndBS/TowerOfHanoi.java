package com.techcrack.DSA.ArraysAndBS;

import java.util.Scanner;

public class TowerOfHanoi {
    private static void towerOfHanoi(int size, char source, char auxiliary, char destination) {
        if (size == 1){
            System.out.println(source + " is moved to " + destination);
            return;
        }
        towerOfHanoi(size - 1, source, destination, auxiliary);
        towerOfHanoi(1, source, auxiliary, destination);
        towerOfHanoi(size - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfDisk = scan.nextInt();
        towerOfHanoi(noOfDisk, 'A', 'B', 'C');
    }
}

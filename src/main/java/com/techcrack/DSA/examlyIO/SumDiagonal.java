package com.techcrack.dsa.examlyIO;// You are using Java
import java.util.Scanner;

class WorkSpace {
    public static void main(String[] args) {
        System.out.println("Number of non-zero elements on both diagonals: "+ countDiagonal());
    }
    
    static int countDiagonal() {
        Scanner scan = new Scanner(System.in);
        
        int size = scan.nextInt();
        
        
        int count = 0;
    
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int val = scan.nextInt();
                
                if (i == j && val != 0)
                    count++;
                else if (i + j == size - 1 && val != 0) {
                        count++;
                }
                
            }    
        }
        
        return count;
    }
}
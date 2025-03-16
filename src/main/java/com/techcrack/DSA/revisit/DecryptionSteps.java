package com.techcrack.dsa.revisit;

public class DecryptionSteps {
    public static int findSteps(String binary, int k) {
        int num = Integer.parseInt(binary, 2); // Convert binary to decimal
        int steps = 0;

        while (num > 1) {
            String bin = Integer.toBinaryString(num); // Convert number to binary string
            
            // Split into k-bit groups
            int len = bin.length();
            int groups = (int) Math.ceil((double) len / k);
            
            // Perform operation to reduce num (e.g., divide, XOR, subtract)
            num -= groups; // Example operation
            
            steps++;
        }
        
        return steps;
    }

    public static void main(String[] args) {
        String binary = "11110";
        int k = 2;
        System.out.println(findSteps(binary, k)); // Output: 3
    }
}

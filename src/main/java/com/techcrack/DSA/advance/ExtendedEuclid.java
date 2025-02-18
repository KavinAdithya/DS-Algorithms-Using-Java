package com.techcrack.dsa.advance;

public class ExtendedEuclid {
    /**
     * This method returns an integer array of three elements:
     * [gcd, x, y], where gcd is the greatest common divisor of a and b,
     * and x and y are coefficients satisfying the equation:
     * a*x + b*y = gcd.
     */
    public static int[] extendedGCD(int a, int b) {
        // Base case: if b is 0, the gcd is a.
        // The coefficients are x = 1 and y = 0 because a*1 + 0 = a.
        if (b == 0) {
            return new int[] { a, 1, 0 };
        }
        
        // Recursively call extendedGCD with (b, a % b).
        int[] result = extendedGCD(b, a % b);
        
        // Extract gcd, and the coefficients from the recursive call.
        int gcd = result[0];
        int x1 = result[1];  // Coefficient for 'b' in the recursive step.
        int y1 = result[2];  // Coefficient for 'a % b' in the recursive step.
        
        // Update coefficients:
        // For the current step, we have:
        // a * x + b * y = gcd.
        // From the recursive call, we had: 
        // b * x1 + (a % b) * y1 = gcd.
        // Note that a % b = a - (a/b)*b.
        // Rearranging gives:
        // a * y1 + b * (x1 - (a/b)*y1) = gcd.
        int x = y1;
        int y = x1 - (a / b) * y1;
        
        return new int[] { gcd, x, y };
    }

    public static void main(String[] args) {
        int a = 3;
        int m = 7;
        int[] result = extendedGCD(a, m);
        int gcd = result[0];
        int x = result[1];
        int y = result[2];
        
        System.out.println("gcd(" + a + ", " + m + ") = " + gcd);
        System.out.println("x = " + x + ", y = " + y);
        System.out.println(a + " * " + x + " + " + m + " * " + y + " = " + (a * x + m * y));
        
        // For a prime modulus, since gcd(3,7) = 1, x is the modular inverse of a modulo m.
        // However, x might be negative. To get the positive inverse, adjust it:
        int modInverse = (x % m + m) % m;
        System.out.println("Modular inverse of " + a + " mod " + m + " is " + modInverse);
    }
}

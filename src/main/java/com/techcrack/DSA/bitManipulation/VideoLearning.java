package com.techcrack.dsa.bitManipulation;

public class VideoLearning {
    public static int findMissingElement(int[] arr) {
        int ans = 0;

        for (int a : arr) {
            ans ^= a;
        }

        return ans;
    }

    public static int iThBit(int num, int n) {
        return (num & (1 << (n - 1))) != 0 ? 1 : 0;
    }

    public static int setIthBit(int num, int n) {
        return num | (1 << n - 1);
    }

    public static int resetIThBit(int num, int n) {
        return num & (~ (1 << n - 1));
    }

    public static int findMissingNumber(int[] arr) {
        int[] hash = new int[32];

        for (int j : arr) {
            int index = 0;
            int num = j;

            while (num > 0) {
                if ((num & 1) == 1) {
                    hash[index]++;
                }
                num >>= 1;
                index++;
            }
        }

        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            ans <<= 1;
            ans |= (hash[i] % 3 == 0 ? 0 : 1);
        }

        return ans;
    }

    public static int findNthMagicNumber(int n) {
        int ans = 0, pow = 5;

        while (n > 0) {
            if ((n & 1) == 1) {
                ans += pow;
            }

            pow *= 5;
            n >>= 1;
        }

        return ans;
    }

    public static int countDigits(int n, int b) {
        return (int) (Math.log(n) / Math.log(b)) + 1;
    }

    public static int nthRowSumPascal(int n) {
        return 1 << (n - 1);
    }

    public static boolean isPowerOfTwo(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }

    public static int countSetBitsBruteForce(int n) {
        int count = 0;
        int totIteration = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
            totIteration++;
        }

        System.out.println("Total Iteration : " + totIteration);

        return count;
    }

    public static int setBits(int n) {
        int count = 0;
        int totIteration = 0;

        while (n > 0) {
            count++;
//            n -= (n & (-n));
            n &= (n - 1);
            ++totIteration;
        }

        System.out.println("Total Iterations : " + totIteration);

        return count;
    }

    public static int findXorN(int n) {
        return n % 4 == 0 ? n :
                n % 4 == 1 ? 1 :
                        n % 4 == 2 ? n + 1 : 0;
    }

    public static int findRangeXor(int a, int b) {
        return findXorN(b) ^ findXorN(a - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 5, 1, 6, 2, 5, 1};

        int[] arr1 = {2, 2, 3, 2, 7, 7, 8, 7, 8, 8, 3};

//        System.out.println(findMissingNumber(arr1));
//        System.out.println(findNthMagicNumber(1));

//        System.out.println(Math.log(1));

//        System.out.println(countDigits(8, 2));
//        System.out.println(nthRowSumPascal(5));

//        System.out.println(isPowerOfTwo(0));

//        System.out.println(countSetBitsBruteForce(10));

        System.out.println(findRangeXor(3,9));
    }
}

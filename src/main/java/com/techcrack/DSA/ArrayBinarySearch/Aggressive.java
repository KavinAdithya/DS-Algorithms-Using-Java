package com.techcrack.DSA.ArrayBinarySearch;
import java.util.Arrays;
import java.util.Scanner;

public class Aggressive {
    //Brute Force
    private static int aggressiveCowBrute(int[] stalls, int cows){
        Arrays.sort(stalls);

        for(int k = 1; k < Integer.MAX_VALUE ; k++) {
            if (isNotPossible(k, stalls, cows))
                return k - 1;
        }
        return 0;
    }

    private static boolean isNotPossible(int max, int[] stalls, int cows){
        int recentStall = stalls[0];
        int countCows = 1;

        for(int k = 1; k < stalls.length; k++){
            if(stalls[k] - recentStall >= max){
                recentStall = stalls[k];
                countCows++;
            }
        }

        return   countCows < cows;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCase = Integer.parseInt(scanner.nextLine());

        while(testCase != 0){
            int stall = scanner.nextInt();
            int cows = scanner.nextInt();

            int[] stalls = new int[stall];

            for(int k = 0; k < stall; k++)
                stalls[k] = scanner.nextInt();

            //System.out.println("Minimum Largest distance to allocate stall for cow is " + aggressiveCowBrute(stalls, cows));

            System.out.println("Minimum Largest distance to allocate stall for cow is " + aggressiveCowOptimal(stalls, cows));


            testCase--;
        }
    }

    private static int aggressiveCowOptimal(int[] stalls, int cows){
        int start = 1;
        int end = 0;

        for(int stall : stalls){
            if(stall > end)
                end = stall;
        }
        Arrays.sort(stalls);

        while(start <= end){
            int mid = (start + end) / 2;
            int countCows = chanceOfCows(stalls,  mid);
            if(countCows >= cows)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return end;
    }

    private static int chanceOfCows(int[] stalls, int max){
        int recentcow = stalls[0];
        int countCows = 1;
        for(int k = 1; k < stalls.length; k++){
            if(stalls[k] - recentcow >= max){
                recentcow = stalls[k];
                countCows++;
            }
        }
        return countCows;
    }
}

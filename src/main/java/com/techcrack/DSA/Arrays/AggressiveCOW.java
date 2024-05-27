package com.techcrack.DSA.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCOW {
    public static int findMinimumDistance(int[] positions, int cows, int stall){

        Arrays.sort(positions);
        int start = 1;
        int end = positions[stall - 1] - positions[0];

        int minimumDistance = Integer.MAX_VALUE;

        while(start <= end){
            int mid = (start + end) / 2;
            if(countCow(positions,mid, cows)){
                minimumDistance = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return minimumDistance;
    }

    public static boolean countCow(int[] positions, int distance, int cows){
        int lastPosition = positions[0];
        int count = 1;
        for(int k = 1; k < positions.length; k++){
            if(positions[k] - lastPosition >= distance){
                count++;
                lastPosition = positions[k];
                if(count == cows)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = Integer.parseInt(scan.nextLine());

        while(testCase != 0){
            int position,cows;
            position = scan.nextInt();
            cows = scan.nextInt();

            int[] positions = new int[position];

            for(int k = 0; k < position; k++){
                positions[k] = scan.nextInt();
            }

            System.out.println(findMinimumDistance(positions, cows, position));
            testCase--;
        }
    }
}
//Spere Online Problem https://www.spoj.com/problems/AGGRCOW/

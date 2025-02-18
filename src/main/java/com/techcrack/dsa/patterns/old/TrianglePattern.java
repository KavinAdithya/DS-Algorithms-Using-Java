package com.techcrack.dsa.patterns;

public class TrianglePattern {
    public static void printPattern(int length){

        boolean decreases = true;
        int starLength = length;
        int spaceLength = 1;

        while(starLength < length + 1){
            for(int k = 1; k < spaceLength; k++)
                System.out.print(" ");
            for(int k = 0; k < starLength; k++)
                System.out.print(k + 1);
            if(decreases){
                starLength--;
                spaceLength++;
            }
            else{
                starLength++;
                spaceLength--;
            }

            if(starLength == 1)
                decreases = false;
            System.out.println();
        }
    }

    public static void main(String[] args){
        printPattern(10);
    }
}

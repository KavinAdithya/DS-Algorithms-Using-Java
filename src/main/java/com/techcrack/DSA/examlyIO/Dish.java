package com.techcrack.dsa.examlyIO;// You are using Java


import java.util.*;

class Dish {
    private static boolean[] isPicked;
    private static int[][] ingredient;
    private static int[] gramsRequired;
    
     private static int serveDish(int index, int times) {
         if (index == ingredient[0].length)
             return 1;

         int count = 0;

         for (int i = 0; i < ingredient.length; i++) {

             for (int j = 0; j < isPicked.length; j++) {

                 if (isPicked[j])
                     continue;

                 if (times == -1) {
                     int each = gramsRequired[j] / 10;
                     isPicked[j] = true;
                    // 1
                     int curTime = ingredient[i][index] / gramsRequired[j] + 1;
                     int curVal = each * gramsRequired[j];
                     if ( each == ingredient[i][index]  || ingredient[i][index] % gramsRequired[j] >= each * 9 )
                         count += serveDish(index + 1, curTime + 1);

                     isPicked[j] = false;
                 }
                 else {
                     int each = times * gramsRequired[j] / 10;
                     if (ingredient[i][index] >= each * 9 && ingredient[i][index] <= each * 11) {
                         isPicked[j] = true;

                         count += serveDish(index + 1, times);

                         isPicked[j] = false;
                     }
                 }

             }
         }

         return count;
     }

    private void getInputPrint() {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        gramsRequired = new int[n];
        isPicked = new boolean[n];
        
        ingredient = new int[m][n];

        for (int i = 0; i < n; i++) {
            gramsRequired[i] = scan.nextInt();
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ingredient[i][j] = scan.nextInt();
            }
        }
        
        System.out.println(serveDish(0, -1));
    }
    
    
    public static void main(String[] args) {
//        new Dish().getInputPrint();

        int n = 8;
        int m = 1;

        isPicked = new boolean[m];

        ingredient = new int[][]{
                                {11}, {13}, {17}, {11}, {16}, {14}, {12}, {18},
                    };

        gramsRequired = new int[]{10};

        System.out.println(serveDish(0, -1));


    }
}
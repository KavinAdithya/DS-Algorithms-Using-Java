package com.techcrack.DSA.ArrayBinarySearch;

public class SpiralMatrix2 {

    /*
     *Given A number, and we create a 2D matrix of n*n
     * And we Needed to traverse the array in spiral matrix
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];

        int left=0;
        int right=n-1;
        int top=0;
        int bottom=n-1;
        boolean leftColumn=false;
        boolean topRow=true;
        boolean bottomRow=false;
        boolean rightColumn=false;
        int row=0;
        int column=0;
        int m=1;

        while(left<=right){
            if((bottom-top)!=1||!leftColumn)
                matrix[row][column]=m;

            //System.out.println(matrix[row][column]+" "+row+" "+column);
            if(left==right)
                break;
            if(topRow){
                column++;
                //System.out.println("top");
                if((column)==(right+1)){
                    rightColumn=true;
                    topRow=false;
                    column=right;
                    row=top+1;
                }
            }
            else if(rightColumn){
                row++;
                //System.out.println("right");
                if((row)==(bottom+1)){
                    rightColumn=false;
                    bottomRow=true;
                    column=right-1;
                    row=bottom;
                }
            }
            else if(bottomRow){
                column--;
                //System.out.println("bottom");
                if(column==(left-1)){
                    leftColumn=true;
                    bottomRow=false;
                    column=left;
                    row=bottom-1;
                }
            }
            else if(leftColumn){
                row--;
                //System.out.println("Left");
                if(row==top){
                    leftColumn=false;
                    top++;
                    bottom--;
                    left++;
                    right--;
                    row=top;
                    column=left;
                    topRow=true;
              //     System.out.println(left+" "+right+" "+top+" "+bottom);

                }
            }

            m++;
        }
        return matrix;
    }
}

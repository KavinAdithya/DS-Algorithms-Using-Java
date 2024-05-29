package com.techcrack.DSA.ArraysAndBS;

public class RotateBinaryArray {

    /*
    *Given a 2d Binary array and target 2d array both are equal we needed to
    * rotate the mat array 90-degree and after 90-degree rotation if the rotated array and target array equal means we neded to say
    * true or else false
     */

    public boolean findRotation(int[][] mat, int[][] target) {
        if(equals(mat,target))
            return true;

        //Rotating the matrix and checking the target and given matrix is same
        //if it is true it will stop iterating
        for(int k=1;k<4;k++){
            mat=rotateMatrix(mat,target);
            if(equals(mat,target))
                return true;
        }

        return false;
    }

    //Rotating the given matrix
    private int[][] rotateMatrix(int[][] mat,int[][] target){
        int length=mat.length;
        int[][] rotated=new int[length][length];

        for(int k=0;k<length;k++){
            for(int d=0;d<length;d++){
                rotated[k][d]=mat[d][length-k-1];
            }
        }

        return rotated;
    }

    //Checking the rotated array and given array is equal or not
    private boolean equals(int[][] mat,int[][] target){

        for(int k=0;k<mat.length;k++){
            for(int d=0;d<mat.length;d++){
                if(mat[k][d]!=target[k][d])
                    return false;
            }
        }
        return true;
    }

    //Optimized Solution
    public boolean findRotation1(int[][] mat, int[][] target) {
        int r0=0,r1=0,r2=0,r3=0;
        int length=mat.length-1;

        for(int k=0;k<=length;k++){
            for(int d=0;d<=length;d++){
                if(target[k][d]==mat[k][length-k])
                    r0++;
                if(target[k][d]==mat[length-k][length-d])
                    r1++;
                if(target[k][d]==mat[length-d][k])
                    r2++;
                if(target[k][d]==mat[k][d])
                    r3++;
            }
        }
        length++;
        int n=length*length;
        if(r1==n||r0==n||r2==n||r3==n)
            return true;
        return false;
    }


}

package com.techcrack.dsa.arrayBinarySearch;

public class DivideChocolate {
    private int findTheMaximum(int[] sweetness, int members){
        members++;

        int maximumSweetness = 0;
        int start  = 1;
        int end = 0;

        for(int sweet : sweetness){
            end += sweet;
            if(sweet < start)
                start = sweet;
        }

        end /= 2;
        while(start <= end){
            int mid = (start + end ) / 2;

            if(isMaximum(sweetness,mid, members )){
                maximumSweetness = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        System.out.println("Max : " + maximumSweetness);
        //return findMini(sweetness, members, maximumSweetness);
        return maximumSweetness;
    }

    private boolean isMaximum(int[] sweetness, int target, int members){
        int sweetSum = 0;
        int count = 0;

        for(int sweet : sweetness){


             if(sweetSum + sweet >= target){
                count++;
                sweetSum = 0;
            }else
                sweetSum += sweet;

        }

        return count >= members;
    }


    public static void main(String[] args) {
        DivideChocolate divideChocolate = new DivideChocolate();
        int[] sweetness = {
                1,2,2,1,2,2,1,2,2
        };

        System.out.println("Minimum Sweetness that you get is : " + divideChocolate.findTheMaximum(sweetness, 2));
    }
}

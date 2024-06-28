package com.techcrack.DSA.ArraysAndBS;

public class Chocolate {
    public static int findMaximumSweetness(int[] sweetness, int members){
        int start = Integer.MAX_VALUE;
        int end = 0;

        for(int sweet : sweetness){
            if(sweet < start)
                start = sweet;
            end += sweet;
        }

        members++;

        int sweet = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            int member = findMembers(sweetness, mid);
            if(member == members){
                sweet = mid;
                start = mid + 1;
            }
            else if(member > members){
                start = mid + 1;
            }else
                end = mid - 1;
        }

        return sweet;
    }

    private static int findMembers(int[] sweetness, int minimum){
        int count = 0;
        int sum = 0;

        for(int sweet : sweetness){
            sum += sweet;
            if(sum >= minimum){
                count++;
                sum = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] sweetness = {1,2,2,1,2,2,1,2,2};
        System.out.println(" I Can get a minimum Sweetness of : " + findMaximumSweetness(sweetness, 2));
    }
}

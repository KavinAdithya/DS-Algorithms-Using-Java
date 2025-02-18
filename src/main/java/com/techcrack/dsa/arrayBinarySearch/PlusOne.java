package com.techcrack.dsa.arrayBinarySearch;

import java.util.*;
public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> list=new ArrayList<>();
        add(digits,digits.length-1,1,list);
        if(list.size()!=digits.length){
            digits=new int[list.size()];
        }

        int k=0;
        for(Integer d:list){
            digits[k]=d;
            k++;
        }

        return digits;
    }

    //Recursively adding the value
    private void add(int[] digits,int length,int carry,List<Integer> list){
        if(length>=0){
            int value=digits[length]+carry;
            carry=value/10;
            value=value%10;
            add(digits,--length,carry,list);
            list.add(value);
        }
    }


    public int[] plusOne1(int[] digits){
        int n=digits.length-1;

        for(int k=n;k>=0;k--){
            if(digits[k]<9){
                digits[k]++;
                break;
            }
            else
                digits[k]=0;
        }

        if(digits[0]==0){
            digits=new int[n+2];
            digits[0]=1;
        }

        return digits;
    }
}

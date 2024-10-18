package com.techcrack.DSA.ArrayBinarySearch;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayInteger {

    //Given a array 1D we needed to convert int k integer and add with n value and return it
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list=new ArrayList<Integer>();
        addTo(list,num,num.length-1,k);

        for(Integer v:list){
            System.out.print(v+" ");
        }

        return list;
    }

    //Using Recursion Algorithm To solve this problem
    private void addTo(List<Integer> list,int[] array,int index,int carry){
        int value=0;
        if(index>=0||carry!=0){
            if(index<0){
                value=carry%10;
                carry/=10;
            }
            else{
                value=(array[index]+carry)%10;
                carry=(array[index]+carry)/10;
            }
            addTo(list,array,--index,carry);
            list.add(value);
        }
    }


    //Using Another Algorithm
    public List<Integer> arrayAdd(int[] num,int k){
        int length=num.length-1;
        int carry=k;
        List<Integer> list=new ArrayList<>();

        while(length>=0||carry>0){
            if(length>=0){
                carry+=num[length];
                length--;
            }
            list.add(0,carry%10);
            carry/=10;
        }

        for(Integer v:list){
            System.out.print(v+" ");
        }


        return list;
    }
}

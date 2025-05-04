package com.techcrack.dsa.examlyIO;

import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> b= new ArrayList<>();
        ArrayList<Integer> v=new ArrayList<>();
         ArrayList<Integer> v1=new ArrayList<>();
        for(int i=1;i<=numRows;i++)
        {
            if(i<=2)
            {
                for(int j=0;j<i;j++)
                {
                    v.add(1);
                }
                
                b.add(new ArrayList<>(v));
                v.clear();
                
            }
            else{
                v = new ArrayList<>(b.get(b.size() - 1));
                v1.add(1);
                for(int k=1;k<v.size();k++)
            {
              
                v1.add(v.get(k)+v.get(k-1));
            }
               
               v1.add(1);
            
               b.add(new ArrayList<>(v1));
               v1.clear();
            }
            
        }
         return b;
    }

    public static void main(String[] args) {
//        System.out.println();
            new Solution()
                    .generate(5)
                    .forEach(System.out::println);
    }
}
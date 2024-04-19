package com.techcrack.DSA.Arrays;

import java.util.List;

public class CountItemsMatching {

    //There  is a give a 2D string array
    /*
    *Each element is an array which as three attribute
    * one attribute - type,color,name
    * we needed to count the number of sub-arrays if matching the value
     */

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int column=-1;
        if(ruleKey.compareTo("type")==0)
            column=0;
        else if (ruleKey.compareTo("color")==0)
            column=1;
        else
            column=2;
        int count=0;
        for(List<String> list:items){
            if(ruleValue.compareTo(list.get(column))==0)
                count++;
        }
        return column;
    }


    /*
      *Another best algorithm which is faster than previous algorithm
     */
    public int countMatches1(List<List<String>> list,String ruleKey,String ruleValue){
        int column=0;
        if(ruleKey.equals("color"))
            column=1;
        else if(ruleValue.equals("name"))
            column=2;
        return solve(list,ruleValue,0,column);
    }

    private int solve(List<List<String>> list,String value,int row,int column){
        if(row==list.size())
            return 0;
        else if(list.get(row).get(column).equals(value))
            return 1+solve(list,value,row+1,column);
        else
            return solve(list,value,row+1,column);
    }




}

package com.techcrack.dsa.arrayBinarySearch;

public class NExistsANDdouble {
    public boolean checkIfExist(int[] arr) {

        int[] tracker=new int[20001];

        for(int k:arr){
            if(k<0)
                tracker[(k*-1)+10000]++;
            else
                tracker[k]++;
        }

        for(int a:arr){
            int div=a/2;

            if((a%2)!=0)
                continue;
            else if(div==0){
                if(tracker[0]>1)
                    return true;
            }
            else if(div<0){
                if(tracker[(div*-1)+10000]!=0)
                    return true;
            }
            else{
                if(tracker[div]!=0)
                    return true;
            }
        }

        return false;
    }
}

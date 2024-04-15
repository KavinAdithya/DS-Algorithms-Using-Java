package com.techcrack.leetcode;

public class ReverseInteger32 {
    public int reverse(int x) {
        int ide=1;
        if(x<0){
            if(x<-2147483647)
                return 0;
            x*=-1;
            ide=-1;
        }
        long sum=0;
        while(x!=0){
            sum=(sum*10)+(x%10);
            x/=10;
        }
        if(sum>2147483647)
            return 0;
        return ((int)sum)*ide;
    }
}

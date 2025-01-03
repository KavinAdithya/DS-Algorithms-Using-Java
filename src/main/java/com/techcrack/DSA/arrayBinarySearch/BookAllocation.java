package com.techcrack.DSA.arrayBinarySearch;

import java.util.Scanner;

public  class BookAllocation {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t-->0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];

            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
            }
            int m=sc.nextInt();
            SP2 ob = new SP2();
            System.out.println(BookAllocation.findPages(a,n,m));
        }
    }
    public static int findPages(int[]A,int N,int M){
        int end = 0;
        int start = Integer.MAX_VALUE;

        for(int k : A){
            end += k;
            if(start > k)
                start = k;
        }

        if(M > N)
            return -1;
        int answer = -1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(isAllocatedBooks(A, mid, M)){
                answer = mid;
                end = mid - 1;
            }else
                start = mid + 1;
        }

        return answer;
    }


    public static boolean isAllocatedBooks(int[] A, int maxPages, int M){
        int count = 1;
        int pages = 0;

        for(int k = 0; k  < A.length; k++){
            if(pages + A[k] > maxPages){
                if(A[k] > maxPages)
                    return false;
                count++;
                pages = A[k];
            }
            else
                pages += A[k];
        }
        return count <= M;
    }
}

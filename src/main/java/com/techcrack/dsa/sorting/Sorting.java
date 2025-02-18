package com.techcrack.dsa.sorting;//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);

			int arr[] = {2,3, 5, 1, 45, 23};
            int n = 6;

            Solution1.quickSort(arr,0,n-1);
			printArray(arr);
} }
// } Driver Code Ends


class Solution1 {
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        if (low >= high)
            return;
        
        int[] mid = partition(arr, low, high);
        quickSort(arr, low, mid[0]);
        quickSort(arr, mid[1], high);
    }
    
    static int[] partition(int arr[], int low, int high) {
        int pivotIndex =  low + (high - low) / 2;
        
        int pivot = arr[pivotIndex];
        int start = low;
        int end = high;
        
        while (start <= end) {
            while (start <= end && arr[start] < pivot)
                start++;
            while (start <= end && arr[end] > pivot)
                end--;
            
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        
        return new int[] {end, start};
    } 
}

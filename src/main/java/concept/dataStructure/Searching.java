package concept.dataStructure;

import java.util.Arrays;

public class Searching {
    int[] array={23,67,9,1,2,34,89};

    //Linear Search
    //Time complexity - best case -> O(1),worst case ->  O(n)
    //Space complexity - O(1)
    private int linearSearch(int target){

        int steps=0;

        for(int k=0;k<array.length;k++) {

            System.out.println(steps++);

            if (array[k] == target)
                return k;
        }

        return -1;
    }

    //Binary Search
    //Time complexity - best case -> O(1),worst case ->  O(n)
    //Space complexity - O(1)

    private int binarySearch(int target){

        Arrays.sort(array);

        int initial=0;
        int end=array.length-1;
        int steps=0;

        while(initial<=end){
            System.out.println(steps++);
            int mid=(initial+end)/2;
            if(array[mid]==target)
                return mid;
            else if (array[mid]>target)
                end=mid-1;
            else
                initial=mid+1;
        }

        return -1;
    }

    //Driver mode
    public static void main(String[] args){
        Searching search=new Searching();
        System.out.println("Linear Search = "+search.linearSearch(-89));
        System.out.println("Binary Search = "+search.binarySearch(90));
    }
}

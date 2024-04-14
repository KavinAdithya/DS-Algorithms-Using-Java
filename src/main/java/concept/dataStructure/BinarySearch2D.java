package concept.dataStructure;

public class BinarySearch2D {

    //We Are Search to find the index of targeted element in a 2d Array
    //Using linear search but its time complexity is O(n^2)
    /*
    *But we Use Binary Search and find the targeted element in a 2d array with a
    * time complexity of O(N)
     */

    public int[] search(int[][] array,int target){
        int start=0;
        int end=array[0].length-1;

        while(start<array.length&&end>=0){
            if(array[start][end]==target)
                return new int[]{start,end};
            else if(target<array[start][end])
                end--;
            else
                start++;
        }
        return new int[]{-1,-1};
    }
}

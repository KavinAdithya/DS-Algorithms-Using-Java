package concept.dataStructure;

public class SortedMatrixSearch {

    /*
    * here the question is to find index of the given target element present in the matrix
    * which is in the form of sorted
    * Here we are applying binary search to find the index of targeted element
    * Time Complexity
     */

    public int[] search(int[][] array,int target){
        int start=0;
        int end=array.length-1;
        int cMid=end/2;
        if(end==0)
            return binarySearch(array,0,0,end,target);
        while(start<(end-1)){
            int mid=(start+end)/2;
            if(array[mid][cMid]==target)
                return new int[]{mid,cMid};
            else if(array[mid][cMid]>target)
                end=mid;
            else
                start=mid;
        }

        if(array[start][cMid]==target)
            return new int[]{start,cMid};
        if(array[start+1][cMid]==target)
            return new int[]{start+1,cMid};
        if(array[start][cMid]>target)
            return binarySearch(array,start,0,start-1,target);
        if(array[start][cMid]<target&&target<array[start][array[start].length-1])
            return binarySearch(array,start,cMid+1,array[start].length-1,target);
        if(array[start+1][cMid]>target)
            return binarySearch(array,start+1,0,cMid-1,target);
        else
            return binarySearch(array,start+1,cMid+1,array[start+1].length-1,target);
    }


    //Actual part of finding the index of targeted element using binary search
    private int[] binarySearch(int[][] array,int row,int start,int end,int target){
        while(start<=end){
            int mid=(start+end)/2;
            if(array[row][mid]==target)
                return new int[]{row,mid};
            else if(array[row][mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return new int[]{-1,-1};
    }
}

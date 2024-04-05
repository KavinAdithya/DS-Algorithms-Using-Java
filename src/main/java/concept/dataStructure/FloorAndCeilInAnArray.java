package concept.dataStructure;

public class FloorAndCeilInAnArray {
    // Floor OR CEil Using Binnary Search  And which is an sorted Array
    public int ceilOrFloor(int[] array,int target,int choicer){

        if(array[0]>target||array[array.length-1]<target)
            return -1;

        int start=0;
        int end=array.length-1;

        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]==target)
                return mid;
            else if(array[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }

        if(choicer==1)
            return end;
        return start;
    }
}

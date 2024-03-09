package concept.dataStructure;


import java.util.Objects;

public class LinearSearch {
    public <T extends Number>int findMyPosition(T array[],T value){
        int n=0;
        for(Number k:array){
            if(Objects.equals(k, value)){
                return n;
            }
            n++;
        }
        return -1;
    }
    private <T extends Number>void sort(T []array){
        for(int outerLoop=0;outerLoop<array.length;outerLoop++){
            int maxIndex=outerLoop;
            for(int innerLoop=outerLoop+1;innerLoop<array.length;innerLoop++){
                if(array[maxIndex].intValue()<array[innerLoop].intValue()){
                    maxIndex=innerLoop;
                }
            }
            T data=array[outerLoop];
            array[outerLoop]=array[maxIndex];
            array[maxIndex]=data;
        }
    }
    public <T extends Number>int binarySearch(T array[],T value){
        sort(array);
        int start=0;
        int end=array.length-1;
        int mid=end/2;
        for(;start<=end;){

            if(Objects.equals(array[mid], value)){
                return mid;
            }
            else if(array[mid].intValue()>value.intValue()){
                start=mid+1;
            }
            else if(array[mid].intValue()<value.intValue()){
                end=mid;
            }
             mid=(start+end)/2;
        }
        return -1;
    }
}

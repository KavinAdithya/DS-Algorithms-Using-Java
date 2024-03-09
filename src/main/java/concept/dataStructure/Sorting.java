package concept.dataStructure;

public class Sorting {
    public <T extends Number>T[] bubbleSort(T[] array){
        for(int innerLoop=0;innerLoop<array.length-1;innerLoop++){
            for(int outerLoop=0;outerLoop<array.length-innerLoop-1;outerLoop++){
                if(array[outerLoop].doubleValue()>array[outerLoop+1].doubleValue()){
                    T value=array[outerLoop];
                    array[outerLoop]=array[outerLoop+1];
                    array[outerLoop+1]=value;
                }
            }
        }
        return array;
    }
    public <T extends Number>T[] selectionSort(T[] array){
        for(int outerLoop=0;outerLoop<array.length-1;outerLoop++){
            int minIndex=outerLoop;
            for(int innerLoop=outerLoop+1;innerLoop<array.length;innerLoop++){
                if(array[minIndex].doubleValue()>array[innerLoop].doubleValue()){
                    minIndex=innerLoop;
                }
            }
            T value=array[outerLoop];
            array[outerLoop]=array[minIndex];
            array[minIndex]=value;
        }
        return array;
    }
    public <T extends Number>T[] insertionSort(T[] array){

        for(int innerLoop=1;innerLoop<array.length;innerLoop++){
            T value1=array[innerLoop];
            int markIndex=innerLoop;

            for(int outerLoop=innerLoop-1;outerLoop>=0;outerLoop--){

                if(value1.doubleValue()<array[outerLoop].doubleValue()){
                    array[outerLoop+1]=array[outerLoop];
                    markIndex=outerLoop;
                    continue;
                }
                break;
            }

            T data=array[markIndex];
            array[markIndex]=value1;
            value1=data;

        }
        return array;
    }

    public <T extends Number>void quickSort(T[] array,int lower,int upper){
        if(lower<upper) {
            int mid = this.<T>partition(array, lower, upper);
            quickSort(array, lower, mid - 1);
            quickSort(array, mid + 1, upper);
        }
    }

    private <T extends Number>int partition(T array[],int lower,int upper){
        T valueCheck=array[upper];
        int index=upper;
        for(int loop=upper-1;loop>=0;loop--){
            if(valueCheck.doubleValue()<array[loop].doubleValue()){
                array[index]=array[loop];
                index=loop;
            }
        }
        T value=array[index];
        array[index]=valueCheck;
        return index;
    }
    private <T extends Number>void sortIntegration(T[] array,int lowerIndex,int midIndex,int upperIndex){
        T[] leftArray=(T[])new Number[midIndex-lowerIndex+1];
        T[] rightArray=(T[])new Number[upperIndex-midIndex];
        for(int leftLoop=0;leftLoop<leftArray.length;leftLoop++){
            leftArray[leftLoop]=array[lowerIndex+leftLoop];
        }
        for(int rightLoop=0;rightLoop<rightArray.length;rightLoop++){
            rightArray[rightLoop]=array[midIndex+1+rightLoop];
        }
        int lower=0;
        int upper=0;
        int mainArray=lowerIndex;
        while(lower<leftArray.length&&upper<rightArray.length){
            if(leftArray[lower].doubleValue()<=rightArray[upper].doubleValue()){
                array[mainArray]=leftArray[lower];
                lower++;
            }
            else {
                array[mainArray]=rightArray[upper];
                upper++;
            }
            mainArray++;
        }
        while(lower< leftArray.length){
            array[mainArray]=leftArray[lower];
            lower++;
            mainArray++;
        }
        while(upper<rightArray.length){
            array[mainArray]=rightArray[upper];
            upper++;
            mainArray++;
        }
    }
    public <T extends Number>void mergeSort(T array[],int lowerIndex,int upperIndex){
        if(lowerIndex<upperIndex){
            int mid=(lowerIndex+upperIndex)/2;
            mergeSort(array,lowerIndex,mid);
            mergeSort(array,mid+1,upperIndex);
            this.<T>sortIntegration(array,lowerIndex,mid,upperIndex);
        }
    }
    public <T extends Number>T[] shellSort(T[] array){
        int gap=(array.length)/2;
        while(gap!=1){
            int copyGap=gap;
            int index=0;
            while(index<gap&&copyGap<array.length){
                if(array[index].doubleValue()>array[copyGap].doubleValue()){
                    T data=array[index];
                    array[index]=array[copyGap];
                    array[copyGap]=data;
                }
                index++;
                copyGap++;
            }
            for(Number k:array){
                System.out.print(k+" ");
            }
            System.out.println();
            gap--;
            //System.out.println(gap);
        }

        System.out.println();
        insertionSort(array);
        for(Number k:array){
            System.out.print(k+" ");
        }
        return array;
    }
}

package concept.dataStructure;

public class ArrayList<T> {

    private T array[];
    private int n=-1;
    ArrayList(int n) {
        array=(T[])new Object[n];
    }
    ArrayList(){array=(T[])new Object[10];
    }
    public boolean add(T value){
        array[++n]=value;
        return true;
    }
    public boolean set(int index,T value){
        if(index<=n){
            array[index]=value;
            return true;
        }
        else{
            return false;
        }
    }
    public int size(){
        return n+1;
    }
    public boolean addAll(ArrayList<T> list) throws Exception{
        for(int n=0;n<list.size();n++){
            this.n++;
                array[this.n]=list.get(n);
        }
        return true;
    }
    public T get(int index) throws Exception{
        if(index>size()) {
            throw new Exception("Index Not In Range!!!");
        }
        return array[index];
    }
    public boolean add(int index,T value){
        n++;
        T data=value;
        for(;index<=n;index++){
          T duplicate=array[index];
          array[index]=data;
          data=duplicate;
        }
//        for(int k=0;k<=n;k++){
//            System.out.println(array[k]);
//        }
        return true;
    }
    public T[] getMembersAsArray(){
        T[] arr=(T[])new Object[n+1];
        for(int k=0;k<=n;k++){
          //  System.out.println(array[k]);
            arr[k]=array[k];
        }
        return arr;
    }
    public void printArray(){
        for(int k=0;k<100000;k++){
            getMembersAsArray();
        }
    }
    public boolean clear(){
        for(int loop=0;loop<=n;loop++){
            array[loop]=null;
        }
        n=-1;
        return true;
    }
    public boolean isEmpty(){
        return n==-1;
    }
    public boolean containsAll(ArrayList<T> methodList){
        try{
            if(methodList.size()>n+1){
                return false;
            }
            int mL=0;
            for(int loop=0;loop<=n;loop++){
                if(array[loop]==methodList.get(mL)){
                    mL++;
                }
            }
            if(mL==size()-1){
                return true;
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean contains(T value){
        try{
            for(int loop=0;loop<=n;loop++){
                if(value==array[loop]){
                    return true;
                }
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean retainAll(ArrayList<T> methodList){
        T[] array1=(T[])new Object[methodList.size()];
        int m=-1;
        try{
            int mL=0;
            for(int loop=0;loop<size();loop++){
                for(int innerLoop=0;innerLoop<methodList.size();innerLoop++){
                    if(array[loop]==methodList.get(innerLoop)){
                        array1[++m]=array[loop];
                        break;
                    }
                }
            }
            array=array1;
            n=m;
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
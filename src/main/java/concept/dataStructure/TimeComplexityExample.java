package concept.dataStructure;

public class TimeComplexityExample {
    public int sumOfDigits(int n){
        return (n*(n+1))/2;
    }
    public int sumOfDigits(int n,boolean t){
        int sum=0;
        for(int k=1;k<=n;k++){
            sum+=k;
        }
        return sum;
    }
    public static void main(String[] args){
        TimeComplexityExample tce=new TimeComplexityExample();
        long initial=System.currentTimeMillis();
        System.out.println(tce.sumOfDigits(99999));
        long after=System.currentTimeMillis();
        System.out.println(tce.sumOfDigits(99999,true));
        long now=System.currentTimeMillis();
        System.out.println("Formula method Taken Of "+(after-initial)+" Milli Seconds");
        System.out.println("Non Formula method Taken Of "+(now-after)+" Milli Seconds");
    }
}

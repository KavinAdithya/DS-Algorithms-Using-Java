package concept.dataStructure;
import java.util.*;
public class Arrayss {
    public static void main(String[] args){
        int[] arrayy={1,2,3,4};
        System.out.println(Arrays.toString(arrayy));

        int[][] arraay=new int[2][];
        arraay[0]=new int[5];
        arraay[1]=new int[2];


        //dimensional array memory allocation
        int[][][][] ar=new int[1][][][];
        ar[0]=new int[1][][];
        ar[0][0]=new int[1][];
        ar[0][0][0]=new int[1];


        //Input from math class
        for(int k=0;k<ar.length;k++){
            for(int a=0;a<ar.length;a++){
                for(int v=0;v<ar.length;v++){
                    for(int i=0;i<ar.length;i++){
                        ar[k][a][v][i]=(int)Math.random()*10;
                    }
                }
            }
        }



        //Output
        for(int k=0;k<ar.length;k++){
            for(int a=0;a<ar.length;a++){
                for(int v=0;v<ar.length;v++){
                    for(int i=0;i<ar.length;i++){
                        System.out.println(ar[k][a][v][i]);
                    }
                }
            }
        }


        Scanner scan =new Scanner(System.in);
        for(int k=0;k<arraay.length;k++){
            for(int d=0;d<arraay[k].length;d++){
                arraay[k][d]=scan.nextInt();
            }
        }

        for(int[] array:arraay){
            System.out.println(array);
            for(int n:array)
                System.out.println(n);
        }
    }
}

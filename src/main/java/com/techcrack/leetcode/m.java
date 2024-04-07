package LeetCodeProblem;
import java.util.*;
class Solution {
    public int minimumDeletions(String word, int l) {
        Map<Character,Integer> map=new LinkedHashMap<>();
        char ch=' ';
        int max=0;
        int k=0;
        for(char chh:word.toCharArray()){
            if(map.containsKey(chh)){
                k=map.get(chh)+1;
                map.put(chh,k);
            }
            else
                map.put(chh,1);
            if(map.get(chh)>max){
                max=map.get(chh);
                ch=chh;
            }
        }
        int deleteCounter=0;
        int globalValue=map.get(ch);
        int localValue=0;
        int localGlobal=0;
        Set<Map.Entry<Character,Integer>> s=map.entrySet();
       System.out.println(s);
        //System.out.println(globalValue);
        for(Map.Entry<Character,Integer> entry:s){
            localValue=entry.getValue();
            //System.out.println(localValue);
            //System.out.println(globalValue);
            if((globalValue-localValue)>l){
                localGlobal=globalValue-(localValue+l);
                System.out.println(localGlobal);
                if(localValue<localGlobal)
                    deleteCounter+=localValue;
                else{
                    deleteCounter+=localGlobal;
                    globalValue-=localGlobal;
                    System.out.println(globalValue);
                }
            }
        }
        return deleteCounter;
    }
    public static void main(String []args){
        Solution sol=new Solution();
        System.out.println(sol.minimumDeletions("zzfzzzzppfp",1));
    }
}
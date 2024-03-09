package DSA;
import java.util.ArrayList;
import java.util.List;
public class CheckingOfSymbols {
    int top=-1;
    public void checkSymbols(String s){
        List<Character> list=new ArrayList<>();
        for(int k=0;k<s.length();k++){
            char ch=s.charAt(k);
            if(ch=='('||ch=='['||ch=='{'){
                top++;
                list.add(ch);
            }
            else if(ch==')'||ch=='}'||ch==']'){
                if(top==-1){
                    System.out.println("Error Not In Suffficient of opening "+ch);
                    return;
                }
            else if(ch==']'){
                if(list.get(top)=='['){
                    list.remove(top);
                    top--;
                }
                else{
                    System.out.println("Error Not In Order!!!!");
                    return;
                }
            }
            else if(ch==')'){
                if(list.get(top)=='('){
                    list.remove(top);
                    top--;
                }
                else{
                    System.out.println("Error Not In Order!!!!");
                    return;
                }
            }
            else if(ch=='}'){
                if(list.get(top)=='{'){
                    list.remove(top);
                    top--;
                }
                else{
                    System.out.println("Error Not In Order!");
                    return;
                }
            }
        }
        }
        System.out.println("Symbols Are Balanced!!!");
    }
    public static void main(String[] args){
        CheckingOfSymbols check=new CheckingOfSymbols();
        check.checkSymbols("a+b)-{a-(a=0}");
    }
}

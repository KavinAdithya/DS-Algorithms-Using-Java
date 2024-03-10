package concept.dataStructure;

public class LinkedList<T>{
    private class Node<T>{
        T data=null;
        Node nextNode=null;
        Node(T data){
            this.data=data;
        }
    }
    private Node head=null;
    private  int size=-1;
    public boolean add(T data) {
        Node createdNode = new Node(data);
        try {
            if (head == null) {
                head = createdNode;
            } else {
                Node dupHead = head;
                while (dupHead.nextNode != null) {
                    dupHead = dupHead.nextNode;
                }
                dupHead.nextNode = createdNode;
            }
            size++;
            return true;
        } catch (NullPointerException e) {
            System.out.println(e);
            return false;
        }
    }
    public int size(){
        return size+1;
    }
    public boolean isEmpty(){
        return size==-1;
    }
    public T get(int index){
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException("Invalid Index");
        }
        try {
            int i = 0;
            LinkedList.Node dupHead = head;
            while (index != i&&dupHead.nextNode!=null) {
                //System.out.println(dupHead.data);
                dupHead = dupHead.nextNode;
                i++;
                //System.out.println(dupHead.data);
            }
            return (T) dupHead.data;
        }
        catch(Exception e){
            System.out.println("Something Went Wrong?!"+e);
            return null;
        }
    }
    public T remove(int index){
        if(head==null){
            throw new NullPointerException("List Has been Empty!!!");
        }
        else if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException("Invalid Index!!!");
        }
        else{
            try{
                Node next=null;
                if(index==0){
                    next=head;
                    head=head.nextNode;
                }else {
                    int i = 1;
                    Node dupNode = head;
                    while (index != 1) {
                        dupNode = dupNode.nextNode;
                        i++;
                    }
                    next=dupNode.nextNode;
                    dupNode.nextNode = dupNode.nextNode.nextNode;
                }
                return (T)next.data;
            }
            catch(Exception e){
                System.out.println("Something Went Wrong On removing element From list ?!"+e);
                return null;
            }
        }
    }
}

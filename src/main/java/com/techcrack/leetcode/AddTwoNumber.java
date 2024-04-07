package com.techcrack.leetcode;

public class AddTwoNumber {
    static class ListNode{
        int data=0;
        ListNode nextNode=null;
        ListNode(int data){
            this.data=data;
        }
    }
    public ListNode addTwoList(ListNode list,ListNode list1){
        ListNode head=null;
        ListNode dumyHead=null;
        int carry=0;
        int value=0;
        int data=0;
        while(list!=null||list1!=null||carry!=0){
            if(list==null&&list1!=null){
                value=list1.data+carry;
                list1=list1.nextNode;
            }
            else if(list!=null&&list1==null){
                value=list.data+carry;
                list=list.nextNode;
            }
            else if(list!=null&&list1!=null){
                value=list.data+list1.data+carry;
                list=list.nextNode;
                list1=list1.nextNode;
            }
            else {
                value=carry;
            }
            data=value%10;
            carry=value/10;
            ListNode newNode =new ListNode(data);
            if(head==null){
                head=newNode;
                dumyHead=head;
            }
            else{
                dumyHead.nextNode=newNode;
                dumyHead=dumyHead.nextNode;
            }
        }
        return head;
    }
    public static void main(String[] args){
        AddTwoNumber add=new AddTwoNumber();
        ListNode head=null;
        ListNode head1=null;
        ListNode dum=new ListNode(2);
        head=dum;
        dum.nextNode=new ListNode(4);
        dum.nextNode.nextNode=new ListNode(3);
        head1=new ListNode(5);
        head1.nextNode=new ListNode(6);
        head1.nextNode.nextNode=new ListNode(4);
        ListNode newHead=add.addTwoList(head,head1);
        System.out.println(newHead.data+"  "+newHead.nextNode.data+" "+newHead.nextNode.nextNode.data);
    }
}

package com.techcrack.dsa.sorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class InsertionSortLinkedList {
    public ListNode insertionSortList1(ListNode head) {
        if (head == null)
            return null;

        List<Integer> listElements = new ArrayList<>();
        ListNode dupHead = head;

        while (dupHead != null) {
            listElements.add(dupHead.val);
            dupHead = dupHead.next;
        }

        Collections.sort(listElements);

        ListNode sortedHead = null;
        ListNode prevNode = null;

        for (int n : listElements) {
            ListNode currentNode = new ListNode(n);

            if (sortedHead == null) 
                sortedHead = currentNode;
            else
                prevNode.next = currentNode;
            prevNode = currentNode;
        }

        return sortedHead;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head == null)
            return null;

        List<Integer> listElements = new ArrayList<>();
        ListNode dupHead = head;

        while (dupHead != null) {
            listElements.add(dupHead.val);
            dupHead = dupHead.next;
        }

        Collections.sort(listElements);

        ListNode sortedHead = head;

        for (int n : listElements) {
            sortedHead.val = n;
            sortedHead = sortedHead.next;
        }

        return head;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode sortedList = head;
        while (sortedList.next != null) {
            if (sortedList.val <= sortedList.next.val)
                sortedList = sortedList.next;
            else {
                ListNode temp = sortedList.next;
                sortedList.next = temp.next;

                ListNode start = dummy;

                while (start.next.val <= temp.val)
                    start = start.next;
                temp.next = start.next;
                start.next = temp;
            }
        }

        return dummy.next;
    }
}
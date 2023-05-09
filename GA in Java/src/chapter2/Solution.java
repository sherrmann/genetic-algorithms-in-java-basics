// Definition for singly-linked list.

import java.util.LinkedList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String str1 = "";
        String str2 = "";
        ListNode currentListNode1 = l1;
        ListNode currentListNode2 = l2;

        while(currentListNode1.next != null){
            str1 = currentListNode1.val + str1;
            currentListNode1 = currentListNode1.next;
        }

        while(currentListNode2.next != null){
            str2 = currentListNode2.val + str2;
            currentListNode1 = currentListNode1.next;
        }

        String sum = String.valueOf(Integer.parseInt(str1) + Integer.parseInt(str2));
        
        List<ListNode> resultList = new LinkedList<ListNode>();

        // you can link ListNodes and set val after the object has been created
        for (int i = 1; i < sum.length(); i++) {
            resultList.add(
                new ListNode(Integer.parseInt(String.valueOf(sum.charAt(i))), currentListNode2));
        }

        return null;
    }
}

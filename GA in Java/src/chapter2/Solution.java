// Definition for singly-linked list.
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
        
        for(char ch: sum.toCharArray()){
            
        }

        return null;
    }
}

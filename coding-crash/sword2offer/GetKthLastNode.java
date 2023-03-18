package sword2offer;

import classified.linkedlist.ListNode;

public class GetKthLastNode {

    public ListNode get(ListNode head, int k){

        ListNode fast = head;
        ListNode slow = head;

        while ( k > 0){
            fast = fast.getNext();
            k--;
        }

        while (fast != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;


    }
}

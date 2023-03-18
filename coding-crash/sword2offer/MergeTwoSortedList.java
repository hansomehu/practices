package sword2offer;

import classified.linkedlist.ListNode;

public class MergeTwoSortedList {

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode res = null;
        ListNode pseudoHead = res;

        while( head1.getNext() != null && head2.getNext()!= null ){
            if (head1.getVal() <= head2.getVal()){
                pseudoHead.setNext(head1);
                head1 = head1.getNext();
            }else {
                pseudoHead.setNext(head2);
                head2 = head2.getNext();

            }
        }

        pseudoHead.setNext( head1 == null ? head2 : head1);

        return res.getNext();
    }
}

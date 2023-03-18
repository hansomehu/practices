package classified.linkedlist;

public class SumOf2LinkedList {
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode dummy, head = null;
        dummy = head = new ListNode(0);

        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next;
            l1 = l1.next == null ? null : l1.next;
            l2 = l2.next == null ? null : l2.next;

        }
        /*
         * Follow Up: Suppose the digits are stored in forward order. Repeat the above
         * problem.
         * Solution: Using two stacks, push all the nodes in the two lists into teh
         * stack then pop each
         * node out for further computing
         */

        return dummy.next;
    }
}

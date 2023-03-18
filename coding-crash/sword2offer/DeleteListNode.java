package sword2offer;

public class DeleteListNode {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val){
        if (head.val == val) return head.next;
        head.next = deleteNode(head.next, val);

        return head;
    }

    public ListNode deleteNode_NonRecursive(ListNode head, int val){

        if (head.val == val) return head.next;

        while (head.next != null){
            if (head.next.val == val) head.next = head.next.next;
        }

        return head;
    }
}

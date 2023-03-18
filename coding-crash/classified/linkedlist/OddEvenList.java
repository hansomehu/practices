package classified.linkedlist;

/**
 * 链表的奇偶重排
 * hints 这是找规律硬编码类型的题
 * @author hanson.hu
 */
public class OddEvenList {
    private ListNode solution(ListNode head){
        if (head == null){
            return head;
        }
        ListNode even = head.next;
        ListNode odd = head;

        // evenHead as the head of the even sub list
        ListNode evenHead = even;
        while (even != null && evenHead != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // concat
        odd.next = evenHead;

        return head;
    }
}

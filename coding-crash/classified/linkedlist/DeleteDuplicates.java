package classified.linkedlist;

/**
 * 删除链表中出现的全部重复元素
 * @author hanson.hu
 */
public class DeleteDuplicates {

    private ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next != null && cur.next.val == temp) {
                    // skip
                    cur.next = cur.next.next;
                }
            }
        }

        return null;
    }
}
         
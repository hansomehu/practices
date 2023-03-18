package classified.linkedlist;

/**
 * 链表中倒数最后k个结点，也属于找规律题
 * @author hanson.hu
 */
public class FindKthNodeFromTail {
    public static void main(String[] args) {

    }

    public ListNode solution(ListNode head, int k) {
        // 本题的快慢指的是时间先后，步长都为1
        ListNode s = head;
        ListNode f = head;

        for (int i = 0; i < k; i++) {
            if (f != null) {
                f = f.next;
            } else {
                return null;
            }
        }
        return null;
    }
}

  
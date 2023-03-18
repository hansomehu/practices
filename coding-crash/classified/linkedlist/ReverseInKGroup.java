package classified.linkedlist;

/**
 * @author hanson.hu
 * K个一组反转链表
 */
public class ReverseInKGroup {
    public static void main(String[] args) {

    }

    public ListNode solution(ListNode head, int k){
        // 定位到每次翻转的尾部
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return null;
            }
            tail = tail.next;
        }
        // 准备翻转需要的条件节点
        ListNode pre = null;
        ListNode cur = head;
        // 翻转
        while (cur != tail){
            // 断开准备
            ListNode temp = cur.next;
            // 断开cur指向pre
            cur.next = pre;
            // pre进一个
            pre = cur;
            // cur进一个
            cur = temp;
        }
        // 当前的尾指针（原头指针）指向下一组翻转的链表
       head.next = solution(tail,k);

        return pre;
    }
}

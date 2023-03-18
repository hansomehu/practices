package classified.linkedlist;

/**
 * 链表指定区间内反转
 * @author hanson.hu
 */
public class ReverseBetween {
    public static void main(String[] args) {

    }

    public ListNode solution(ListNode head, int m, int n){
        // 全表头部原记录
        ListNode res = null;
        res.next = head;
        // 准备前序和当前节点
        ListNode pre = res;
        ListNode cur = head;
        // 去到要反转的区间开始处
        for (int i = 0; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        // 开始反转，还是链表反转的顺序
        for (int i = m; i < n; i++) {
            // 断开前准备
            ListNode temp = cur.next;
            // 断开，指向前一个
            cur.next = pre;
            // pre更新为当前
            pre = cur;
            // 当前进一个
            cur = temp;
        }
        // 返回保存的原记录
        return res.next;

    }

    // 反转的问题永远可以使用stack
    public ListNode solution2 (ListNode head, int m, int n){

        return null;
    }
}

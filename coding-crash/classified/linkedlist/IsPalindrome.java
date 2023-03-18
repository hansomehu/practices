package classified.linkedlist;

/**
 * 判断是否为回文链表
 * hints 利用快慢指针找到中间节点，然后断开后半段并反转，再从头开始比较两个链表
 * @author hanson.hu
 */
/**
 * 判断是否为回文链表
 * hints 利用快慢指针找到中间节点，然后断开后半段并反转，再从头开始比较两个链表
 * @author hanson.hu
 */
public class IsPalindrome {

    private ListNode reverse(ListNode head){
        ListNode pre = null;

        // reverse is a fundamental operation for list!!! master it!!!
        while (head.next != null){
            // break
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    private boolean solution(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the nodes after the middle
        ListNode node = reverse(slow);
        while (head != null && node != null){
            if (head.val != node.val){
                return false;
            }
            head = head.next;
            node = node.next;
        }

        return true;
    }
}
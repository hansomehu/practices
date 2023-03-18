package classified.linkedlist;

import java.util.Stack;

public class ReverseLinkedList {

    // time O(N) space O(1)
    public ListNode solution(ListNode head) {
        ListNode pre = new ListNode(0), next, cur = head;

        // 重点就是这个pre的使用
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    // using stack
    public ListNode solution2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head.next != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode res = stack.peek();
        ListNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            node.next = stack.peek();
        }

        return res;
    }

    // double linked lists
    public ListNode solution3(ListNode head){
        ListNode newHead = null;

        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;

            head = next;
        }

        return newHead;
    }
}

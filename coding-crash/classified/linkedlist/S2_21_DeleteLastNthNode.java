package classified.linkedlist;

import java.util.Stack;

public class S2_21_DeleteLastNthNode {
    /**
     * https://leetcode.cn/problems/SLwz0R/
     * 删除链表的倒数第 n 个结点
     * 这道题用stack快速解就行
     */

    public ListNode remove(ListNode head, int n){
        if (head == null) return null;

        ListNode res = new ListNode(0);
        res.setNext(head);

        int l = getLength(head);



        return res.getNext();
    }

    private int getLength(ListNode head) {
        int res = 1;
        while(head.getNext() != null){
            head = head.getNext();
            res += 1;
        }
        return res;
    }

    // using Stack
    public ListNode remove2(ListNode head, int n){
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = head;
        while(dummy != null){
            stack.add(dummy);
            dummy = dummy.getNext();
        }

        ListNode target = null;
        for (int i = 1; i < n; i++) {
            target = stack.pop();
        }
        stack.pop().setNext(target.getNext());


        return head;
    }

}

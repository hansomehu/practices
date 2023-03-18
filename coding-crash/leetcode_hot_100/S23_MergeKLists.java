package leetcode_hot_100;


import classified.linkedlist.ListNode;

public class S23_MergeKLists {
    /*
    https://leetcode.cn/problems/merge-k-sorted-lists/
    合并k个链表
     */
    private ListNode solution(ListNode[] lists){
        ListNode res = null;

        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }

        return res;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.getVal() < bPtr.getVal()) {
                tail.setNext(aPtr);
                aPtr = aPtr.getNext();
            } else {
                tail.setNext(bPtr);
                bPtr = bPtr.getNext();
            }
            tail = tail.getNext();
        }
        tail.setNext((aPtr != null ? aPtr : bPtr));

        return head.getNext();
    }
}

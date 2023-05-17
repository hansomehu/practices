package classified.linkedlist;

public class ReverseRange {
    /*
    区间反转链表
    反转从位置 left 到位置 right 的链表节点
    https://leetcode.cn/problems/reverse-linked-list-ii/
     */
    private ListNode reverse(ListNode head, int left, int right){
        ListNode pseudoNode = new ListNode(-1);
        pseudoNode.next = head;

        // locate one node before and after the range verge
        // locate the start and end node of the range
        ListNode preRange = pseudoNode, postRange = pseudoNode, firstNode = pseudoNode, lastNode = pseudoNode;
        for (int i = 1; i < right; i++) {
            if (i < left) preRange = preRange.next;
            if (i < right) postRange = postRange.next;
        }

        // cut off the range

        // reverse the range

        // concatenate

        return pseudoNode.next;
    }

    private void reverseLinkedList(ListNode head){

    }
}

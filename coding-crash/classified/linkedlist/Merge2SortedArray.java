package classified.linkedlist;

/**
 * 合并两个有序链表
 * @author hanson.hu
 */
public class Merge2SortedArray {

    public static void main(String[] args) {

    }

    public ListNode solution(ListNode list1, ListNode list2){
        // 构建返回节点和辅助虚拟节点
        ListNode dummy = new ListNode(-1);
        // 指向组合后的起始node的内存地址
        ListNode res = dummy;

        // 循环判断大小
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                dummy.next = list1;
                dummy = dummy.next;
                list1 = list1.next;
            }else {
                // list1.val <= list2.val
                dummy.next = list2.next;
                dummy = dummy.next;
                list2 = list2.next;
            }
        }

        // 拼装剩余的节点
        if (list1 != null){
            dummy.next = list1;
        }
        if (list2 != null){
            dummy.next = list2;
        }

        return res.next;

    }
}
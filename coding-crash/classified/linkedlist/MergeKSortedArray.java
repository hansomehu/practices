package classified.linkedlist;


import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 合并K个排序数组
 * 利用PriorityDeque进行辅助
 * 也可以使用分治，两两进行merge
 * @author hanson.hu
 */
public class MergeKSortedArray {
    public static void main(String[] args) {

    }

    public ListNode merge(ArrayList<ListNode> lists){
        // 构建小顶堆，并将每个List的头元素放入其中
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((v1, v2) ->
                v1.val - v2.val);
        for (ListNode list : lists) {
            if (list != null){
                priorityQueue.add(list);
            }
        }
        // 构建辅助节点
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        // 将pq中的元素按序构成list
        if (!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            dummy.next = node;
            if (node.next != null){
                priorityQueue.add(node.next);
            }
        }

        return res.next;
    }
}
package classified.linkedlist;

/**
 * 判断链表是否有环，这是一种找规律的题，编码easy
 * @author hanson.hu
 */
public class HasCycle {
    public static void main(String[] args) {

    }

    public ListNode solution(ListNode list){
        if (list == null || list.getNext() == null){
            return null;
        }
        ListNode s = list;
        ListNode f = list;

        while (s != null && f != null){
            if (s.getNext() == f.getNext().getNext()){
                return s.getNext();
            }
            s = s.getNext();
            f = f.getNext().getNext();
        }

        return null;
    }
}

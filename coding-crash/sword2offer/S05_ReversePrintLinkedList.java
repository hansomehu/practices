//package sword2offer;
//
//import java.util.*;
//import com.sun.jmx.remote.internal.ArrayQueue;
//import structure_oriented.linkedlist.LinkedListNode;
//
///**
// * 倒序打印链表全部节点
// * Return all nodes in a LinkedList in reverse
// * Using stack for help
// * @author hanson.hu
// */
//public class S05_ReversePrintLinkedList {
//
//    public ArrayList<LinkedListNode> print(LinkedListNode node) {
//        // the recommended practice for Stack in JDK1.8 and higher
//        ArrayDeque<LinkedListNode> deque = new ArrayDeque<>();
//        ArrayList<LinkedListNode> list = new ArrayList<>();
//        if (node == null)
//            return null;
//        deque.add(node);
//
//        while (node.getNext() != null) {
//            deque.add(node.getNext());
//            node = node.getNext();
//        }
//
//        while (deque.pop() != null) {
//            list.add(deque.pop());
//        }
//
//        return list;
//    }
//
//    public ArrayList<LinkedListNode> print_recursion(LinkedListNode node) {
//        ArrayList<LinkedListNode> list = new ArrayList<>();
//        if (node == null)
//            return null;
//
//        if (node.getNext() != null) {
//            print_recursion(node.getNext());
//        }
//
//        // or System.out.println();
//        list.add(node);
//        return list;
//
//    }
//
//}

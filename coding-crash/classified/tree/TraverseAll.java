package classified.tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraverseAll {
    /*
    pre-order
     */

    // 先序递归法
    public void pre(TreeNode head){
        if (head == null) return;
        System.out.println(head.getData());
        pre(head.getLeft());
        pre(head.getRight());

    }


    // 先序栈
    public void pre2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>(); // opt:new LinkedList
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                System.out.println(node.getData()); // 反着来先入后出，因为是Stack
                stack.push(node.getRight());
                stack.push(node.getLeft());
            }
        }
    }

    // 队列实现先序遍历
    public void traverseByLayer(TreeNode head){
        if (head == null) {
            return;
        }

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(head);
        while (!deque.isEmpty()){
            TreeNode cur = deque.poll();
            System.out.println(cur.getData());
            if (cur.getLeft() != null) {
                deque.add(cur.getLeft());
            }
            if (cur.getRight() != null) {
                deque.add(cur.getRight());
            }

        }
    }

    /*
    in-order
     */

    public void middle(TreeNode head){
        if (head == null) {
            return;
        }
        middle(head.getLeft());
        System.out.println(head.getData());
        middle(head.getRight());
    }


    /**
     * non-recursive in-order
     * 中序遍厉 左-中-右
     * 通过栈的方式来实现
     * 1、首先一直root.left将根的左子树的全部左孩子压入栈中
     * 2、再get left是null 往上弹一个出来
     * 3、将上一个节点入res并弹入right
     * 循环2、3
     */
    public List<Integer> mid2(TreeNode head){
        Stack<TreeNode> stack = new Stack<>(); //stk
        ArrayList<Integer> res = new ArrayList<>();

        while(head != null || !stack.isEmpty()){
            while (head != null){ // 该node没有左右孩子弹出
                stack.push(head); // 入中-左，出左-中
                head = head.getLeft();
            }

            head = stack.pop();
            res.add(head.getData());
            head = head.getRight();
        }

        return res;
    }

    public void mock(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){

            while (root != null){
                stack.push(root);
                root = root.getLeft();
            }

            TreeNode node = stack.pop(); // 左树的最后一个左子树
            System.out.println(node.getData());
            root = root.getRight(); // 获取它的右子树
        }
    }


    /*
    post-order
     */

    // 递归解法
    public void post(TreeNode head){
        if (head == null) return;
        post(head.getLeft());
        post(head.getRight());
        System.out.println(head.getData());
    }

    // 将中-右-左存入栈后再弹出
    private List<Integer> traverse(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        TreeNode cur = root;

        while ( cur != null || !stack.isEmpty()){
            while (cur != null){
                temp.add(cur.getData());
                stack.push(cur);
                cur = cur.getRight(); // 和先序反着来
            }

            if (!stack.isEmpty()){
                cur = stack.pop();
                cur = cur.getLeft();
            }
        }

        return new ArrayList(){
            {
                for (Integer integer : temp) {
                    add(integer);
                }
            }
        };
    }

    public void mock1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> resInReverse = new Stack<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                resInReverse.add(root.getData());
                stack.add(root);
                root = root.getRight();
            }

            while (!stack.isEmpty()){
                root = stack.pop().getLeft(); // 弹出上一个节点取其左节点

            }
        }
    }



}

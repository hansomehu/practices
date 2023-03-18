package classified.tree;

import java.util.Deque;
import java.util.LinkedList;

public class S98_ValidateBST {
    /*
    https://leetcode.cn/problems/validate-binary-search-tree/

    BST中序遍历出来是从小到大的有序数列
     */
    private boolean validate(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        int preVal = Integer.MIN_VALUE;

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.getLeft();
            }

            if (stack.peek().getData() <= preVal) return false;
            preVal = stack.pop().getData();
            root = root.getRight();
        }

        return true;
    }
}

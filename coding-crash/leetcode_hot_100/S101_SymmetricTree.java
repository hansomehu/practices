package leetcode_hot_100;

import classified.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class S101_SymmetricTree {
    /*
    https://leetcode.cn/problems/symmetric-tree/description/
    镜像对称的二叉树，可以用递归来做，也可以用队列作为辅助将递归问题转化为迭代问题
     */
    private boolean check(TreeNode root){
        TreeNode L = root.getLeft(), R = root.getRight();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(L);queue.offer(R);

        for(; !queue.isEmpty();){
            L = queue.poll();
            R = queue.poll();
            if (L == null && R == null) continue;
            if (L.getData() != R.getData()) return false;

            queue.offer(L.getLeft());
            queue.offer(R.getRight());

            queue.offer(L.getRight());
            queue.offer(R.getLeft());
        }

        return true;
    }
}

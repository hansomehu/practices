package classified.tree;

public class IsBalancedBinaryTree {

    /**
     * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
     * 判断一棵树是不是平衡二叉树
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
     *
     * 递归 + 最大深度
     */

    int maxDepth(TreeNode head){
        if (head == null) return 0;

        return Math.max(maxDepth(head.getLeft()), maxDepth(head.getRight()))+1;
    }

    public boolean solution(TreeNode root){
        if (root == null) return false;

        return Math.abs(maxDepth(root.getLeft()) - maxDepth(root.getRight())) <= 1
                && solution(root.getLeft()) && solution(root.getRight());
    }
}

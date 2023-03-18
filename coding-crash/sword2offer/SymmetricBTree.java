package sword2offer;

import classified.tree.TreeNode;

/**
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * 成立条件：
 * 它们的两个根结点具有相同的值
 * 每个树的右子树都与另一个树的左子树镜像对称
 */
public class SymmetricBTree {

    public boolean judge(TreeNode root){

        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.getData() == q.getData() && check(p.getLeft(), q.getRight()) && check(p.getRight(), q.getLeft());
    }
}

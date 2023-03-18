package sword2offer;

import classified.tree.TreeNode;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class BST2DoubleList {

    // pre是dfs遍历完后的尾节点
    TreeNode pre, head;

    public TreeNode transform(TreeNode root){
        dfs(root);
        head.setLeft(pre);
        pre.setRight(head);

        return head;
    }

    private void dfs(TreeNode cur) {
        dfs(cur.getLeft());
        if (pre != null) pre.setRight(cur);

        // 只有中序遍历的第一个节点会满足这个条件，也就是最后list的头节点
        else head = cur;
        cur.setLeft(pre);
        pre = cur;
        dfs(cur.getRight());
    }
}

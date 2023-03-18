package classified.tree;

public class KthLargestNodeValBST {

    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
     * 二叉搜索树的第k大结点
     *
     * BST的中序遍历是从小到大，中序的倒序就是从大到小
     * 在倒序中序遍历的时候加上一个变量控制好遍历的次数就可以最大程度减少时间复杂度
     */

    int res, k;

    public int solution(TreeNode root, int k){
        this.k = k;
        dfs(root);

        return res;
    }

    void dfs(TreeNode root){
        if (root == null) return;

        dfs(root.getRight());
        if (k == 0) return;
        if (--k == 0) res = root.getData(); // 这里print的就是上上行的right的值，也就是最后一个right
        dfs(root.getLeft());
    }
}

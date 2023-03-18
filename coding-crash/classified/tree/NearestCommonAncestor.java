package classified.tree;

public class NearestCommonAncestor {

    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     * BST上的最近公共祖先
     * 当题目要求成立时只有三种情况：
     * 1 - p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）
     * 2 - p=root，且 q 在 root 的左或右子树中
     * 3 - q=root，且 p 在 root 的左或右子树中
     */

    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q){
        while (root != null){
            if (root.getData() < p.getData() && root.getData() < q.getData()) root = root.getRight(); // case 2
            else if (root.getData() > p.getData() && root.getData() > q.getData()) root = root.getLeft(); // case 3
            else break;
        }

        return root; // case 1
    }


    /**
     * 在普通二叉树上找最近公共祖先 dfs
     * 根据left和right是否为空一共有四种情况
     */
    public TreeNode solution2(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) return root;
        TreeNode left = solution2(root.getLeft(), p, q);
        TreeNode right = solution2(root.getRight(), p, q);

        if (left == null && right == null) return null; // case 1
        if (right == null) return left;
        if (left == null) return right;

        return root; // both not null

    }
}

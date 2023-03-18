package classified.tree;

/**
 * @author hanson.hu
 *
 * 二叉树的最大深度
 */
public class MaxDepth {
    public int solution(TreeNode head){
        if (head == null) return 0;

        return Math.max(solution(head.getLeft()), solution(head.getRight()))+1;
    }

    // dfs solution

}

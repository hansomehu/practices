package classified.tree;

/**
 * 从根节点到叶子节点的和是否为目标值
 *
 * @author hanson.hu
 */
public class PathSum {

    public boolean solution(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        if (root.getRight() == null && root.getLeft() == null && sum - root.getData() == 0){
            return true;
        }

        return solution(root.getLeft(), sum - root.getData()) || solution(root.getRight(), sum - root.getData());
    }
}

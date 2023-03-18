package sword2offer;

import classified.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class BTreeLevelOrder_1 {

    public Object[] print(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.add(node.getData());
            if (node.getLeft() != null) queue.add(node.getLeft());
            if (node.getRight() != null) queue.add(node.getRight());
        }
        Object[] res = ans.toArray();

        return res;
    }
}

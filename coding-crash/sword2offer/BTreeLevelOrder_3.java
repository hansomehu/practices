package sword2offer;

import classified.tree.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class BTreeLevelOrder_3 {

    public List<List<Integer>> print(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i <= currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.getData());
                if (node.getLeft() != null) queue.add(node.getLeft());
                if (node.getRight() != null) queue.add(node.getRight());

                if (ans.size() % 2 != 0) Collections.reverse(level);

            }
            ans.add(level);

        }

        return ans;
    }
}

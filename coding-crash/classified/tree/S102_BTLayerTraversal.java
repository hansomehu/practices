package classified.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S102_BTLayerTraversal {
    /*
    使用队列，poll它出来之前先push它的children进去

     */
    public List<List<Integer>> layerTraverse(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> elmOfCurLayer = new ArrayList<>();
            int sizeOfCurLayer = queue.size();
            for (int i = 0; i < sizeOfCurLayer; i++) {
                TreeNode node = queue.poll();
                elmOfCurLayer.add(node.getData());

                if (node.getLeft() != null){
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null){
                    queue.add(node.getRight());
                }
            }

            res.add(elmOfCurLayer);
        }

        return res;
    }
    
}

package sword2offer;

import classified.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int target){
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        path.offerLast(root.getData());
        target -= root.getData();
        if (root.getLeft() == null && root.getRight() == null && target == 0) res.add(new ArrayList<>(path));
        dfs(root.getLeft(), target);
        dfs(root.getRight(), target);

        // trim
        path.pollLast();
    }
}

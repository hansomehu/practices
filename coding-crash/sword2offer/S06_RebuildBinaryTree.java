package sword2offer;

import classified.tree.TreeNode;

import java.util.Arrays;

public class S06_RebuildBinaryTree {
    /**
     *  rebuild a binary tree with given pre-order and mid-order parse sequence
     *  1. locate the root node and its left and right sub-tree
     *  step into recursive logic:
     *  {
     *  2. for the left sub-tree:
     *     locate the root node and its left and right sub-tree
     *  3. for the right sub-tree:
     *     locate the root node and its left and right sub-tree
     *
     *     ---> break untill  subtree is null
     *  }
     * @ref Java.util.Arrays.copyOfRange() Method
     *  original − This is the array from which a range is to to be copied.
     *  from − This is the initial index of the range to be copied, inclusive.
     *  to − This is the final index of the range to be copied, exclusive.
     */

    public TreeNode rebuild(int[] pre, int[] mid){
        if (pre == null || mid == null) return null;
        if (pre.length != mid.length) return null;
        if (pre.length == 0 || mid.length == 0) return null;

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == mid[i]){
                root.setLeft(rebuild(
                        // left sub-tree of current root node in pre-order
                        Arrays.copyOfRange(pre,1,i+1),
                        // left sub-tree of current root node in mid-order
                        Arrays.copyOfRange(mid,0,i)
                ));

                root.setRight(rebuild(
                        // right sub-tree of current root node in pre-order
                        Arrays.copyOfRange(pre,i+1,pre.length),
                        // right sub-tree of current root node in mid-order
                        Arrays.copyOfRange(mid,i+1,mid.length)
                ));

            }

        }
        return root;

    }
}

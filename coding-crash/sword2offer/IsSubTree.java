package sword2offer;

import classified.tree.TreeNode;

public class IsSubTree {
    public boolean isSubStructure(TreeNode A, TreeNode B){

        return nodeCompare(A, B) || nodeCompare(A.getLeft(), B) || nodeCompare(A.getRight(), B);
    }

    public boolean nodeCompare(TreeNode A, TreeNode B){
        if (B == null) return true;
        if (A == null || A.getData() != B.getData()) return false;
        return nodeCompare(A.getLeft(), B.getLeft()) && nodeCompare(A.getRight(), B.getRight());

    }
}

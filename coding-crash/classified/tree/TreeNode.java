package classified.tree;

// represent the binary-tree in the form of left-right children
public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;

    // no agrs constructor
    public TreeNode() {

    }

    // all args constructor
    public TreeNode(int data, TreeNode left, TreeNode right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;

    }

    public TreeNode(int data) {
        super();
        this.data = data;

    }



    // setters and getters

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }


}

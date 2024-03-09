package Tree;

/**
 * 二叉树
 */
public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int val;

    public TreeNode() {
    }

    public TreeNode(TreeNode left, int val, TreeNode right){
        this.left = left;
        this.val = val;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

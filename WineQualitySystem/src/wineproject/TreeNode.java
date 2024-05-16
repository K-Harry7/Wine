package wineproject;

public class TreeNode {
    private Wine data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Wine data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Wine getData() {
        return data;
    }

    public void setData(Wine data) {
        this.data = data;
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

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public void traverse() {
        if (left != null) {
            left.traverse();
        }
        System.out.println(data);
        if (right != null) {
            right.traverse();
        }
    }

    public void swapLeft(TreeNode trunk) {
        TreeNode temp = this.left;
        this.left = trunk;
        trunk.left = temp;
    }

    public void swapRight(TreeNode trunk) {
        TreeNode temp = this.right;
        this.right = trunk;
        trunk.right = temp;
    }
}

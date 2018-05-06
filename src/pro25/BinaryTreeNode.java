package pro25;

/**
 * @author linazhu
 * @Description 二叉树的一个节点
 */
public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(int val) {
        super();
        this.val = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

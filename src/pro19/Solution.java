package pro19;

/**
 * @author linazhu
 * @Description 二叉树的镜像
 */

/**
 * 思路：
 * 交换非叶子结点的左右子树
 * 1. 交换非叶结点的左右子树
 * 2. 递归，该结点的左右子树的结点也要进行交换
 */
public class Solution {

    public void mirror(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        // 交换非叶结点的左右两个结点
        BinaryTreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;
        // 递归的将该结点左右子树进行结点交换
        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }
    }
}

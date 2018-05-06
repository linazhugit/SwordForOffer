package pro18;

/**
 * @author linazhu
 * @Description 树的子结构
 */

/**
 * 知识点：
 * 二叉树的遍历一般有两种方法，循环和递归，一般递归比较好实现，是首选
 * 思路：
 * 首先在树1中找到与树2根节点相同的节点
 * 然后判断以这个结点为根的结构是否与树2的结构相同
 */
public class Solution {
    public boolean HasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            // 如果root1根节点和root2的根节点值相同，则判断以该结点为根的树是否相同
            if (root1.val == root2.val) {
                result = doesTree1HasTree2(root1, root2);
            }
            // 递归遍历左右子树
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean doesTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HasTree2(root1.left, root2.left)
                && doesTree1HasTree2(root1.right, root2.right);
    }
}

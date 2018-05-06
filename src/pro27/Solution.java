package pro27;

/**
 * @author linazhu
 * @Description 二叉搜索树与双向链表
 */

/**
 * 注意：由于Java值传递的特性，将pLastNode定义为成员变量；
 * 若TreeNode pLastNode = null;定义在Convert方法中，并通过参数传递到convertNode方法中，
 * 在convertNode方法中修改pLastNode不会对Convert方法中pLastNode = null有任何影响。
 */
public class Solution {
    BinaryTreeNode pLastNode = null;

    public BinaryTreeNode convert(BinaryTreeNode pRootOfTree) {
        convertNode(pRootOfTree);
        BinaryTreeNode pHeadNode = pLastNode;
        // pLastNode指向双向链表的尾结点
        // 返回的是链表的头结点，需要由尾结点一直向左遍历
        while (pHeadNode != null && pHeadNode.left != null) {
            pHeadNode = pHeadNode.left;
        }
        return pHeadNode;
    }

    private void convertNode(BinaryTreeNode pNode) {
        if (pNode == null) {
            return;
        }
        BinaryTreeNode pCurrent = pNode;
        if (pCurrent.left != null) {
            convertNode(pCurrent.left);
        }
        pCurrent.left = pLastNode;
        if (pLastNode != null) {
            pLastNode.right = pCurrent;
        }
        pLastNode = pCurrent;
        if (pCurrent.right != null) {
            convertNode(pCurrent.right);
        }
    }
}

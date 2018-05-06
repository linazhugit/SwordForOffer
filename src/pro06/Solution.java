package pro06;

import java.util.Arrays;

/**
 * @author linazhu
 * @Description 输入二叉树的前序遍历和中序遍历结果, 重建二叉树并输出头节点
 */
public class Solution {

    public static BinaryTreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder) throws Exception {
        boolean isHave = false;
        if (preOrder == null || inOrder == null) {
            return null;
        }
        if (preOrder.length != inOrder.length) {
            throw new Exception("长度不一样－非法输入");
        }
        BinaryTreeNode root = new BinaryTreeNode();
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == preOrder[0]) {
                isHave = true;
                root.val = inOrder[i];
                // 递归
                root.left = reConstructBinaryTree(Arrays.copyOfRange(preOrder, 1, i + 1)
                        , Arrays.copyOfRange(inOrder, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(preOrder, i + 1, preOrder.length)
                        , Arrays.copyOfRange(inOrder, i + 1, inOrder.length));
            }
        }
        if (!isHave) {
            throw new Exception("不包含根节点－非法输入");
        }
        return root;
    }

}

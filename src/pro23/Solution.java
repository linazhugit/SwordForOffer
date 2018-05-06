package pro23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author linazhu
 * @Description 从上往下打印二叉树
 */

/**
 * 思路：
 * 结点入队列，结点的子节点如队列，打印结点（结点出队列）
 * (顶级接口)Collection-->Queue-->Deque-->LinkedList(实现类)
 * 可以使用LinkedList实现堆栈和队列
 */
public class Solution {

    public ArrayList<Integer> printFromTopToBottom(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        // 先把根节点加入队列
        queue.add(root);
        BinaryTreeNode tmpNode;
        // 循环取出结点，加入该结点的子结点
        while (!queue.isEmpty()) {
            tmpNode = queue.poll();
            result.add(tmpNode.val);
            if (tmpNode.left != null) {
                queue.add(tmpNode.left);
            }
            if (tmpNode.right != null) {
                queue.add(tmpNode.right);
            }
        }
        return result;
    }
}

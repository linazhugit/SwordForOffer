package pro25;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author linazhu
 * @Description 二叉树中和为某一值的路径
 */

/**
 * 思路：
 * 1. 从根节点开始，使用前序遍历，被遍历到的结点入栈并累加路径值
 * 2. 到叶子结点时，如果路径值与输入的目标值相同，则是符合条件的路径；
 * 如果路径值与输入的目标值不相同，则弹出最后一个结点，同时减去该结点的值，返回到父结点，并遍历该父结点下的另一条路径
 * 注意：Stack保存路径信息存在的问题是：当找到一条符合条件的路径时，无法在不将元素弹出栈的情况下获取元素信息
 */
public class Solution {
    // paths是路径集合
    static ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    // path是一条符合条件的路径
    static ArrayList<Integer> path;

    public static ArrayList<ArrayList<Integer>> FindPath(BinaryTreeNode root, int target) {
        // 当前路径的路径值
        int currentSum = 0;
        if (root == null) {
            return paths;
        }
        // Stack保存结点路径
//		Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> stack = new LinkedList<>();
        findPath(root, target, currentSum, stack);
        return paths;
    }

    private static void findPath(BinaryTreeNode node, int target, int currentSum,
                          LinkedList<Integer> stack) {
        // 节点入栈
        stack.push(node.val);
        currentSum += node.val;
        // 找到一条合适的路径
        if (currentSum == target && node.left == null && node.right == null) {
            path = new ArrayList<>();
            for (int i = 0; i < stack.size(); i++) {
                path.add(0, stack.get(i));
            }
            // 将这一条符合条件的路径加入返回的路径集合中
            paths.add(path);
        }
        // 如果不是叶子结点，则遍历它的子结点
        if (node.left != null) {
            findPath(node.left, target, currentSum, stack);
        }
        if (node.right != null) {
            findPath(node.right, target, currentSum, stack);
        }
        // 在返回父结点之前，删除路径上当前结点
        // 删除当前结点的情况是：已经到达叶子结点，但是currentSum!=target，所以删除当前结点，
        // 返回父结点，继续遍历父结点的另外一个儿子
        stack.pop();
    }
}

package pro07_1;

import java.util.LinkedList;


/**
 * @author linazhu
 * @Description 用两个栈实现队列 方式二
 */

/**
 * 用两个队列实现一个栈
 * 思路：
 * 弹出时，从队列一移到队列二，直到队列一中只剩一个元素后弹出
 * 插入时，将元素插入到不为空的那个队列中，若两个队列都为空，则插入到第一个队列中
 * 注意：除了操作过程中(比如，队列元素移动的过程中)，不存在两个队列同时不为空的情况
 */
public class Solution {

    private static LinkedList<Integer> queue1 = new LinkedList<>();
    private static LinkedList<Integer> queue2 = new LinkedList<>();

    // 插入元素
    public static void push(int node) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.addLast(node);
        } else if (!queue1.isEmpty()) {
            queue1.addLast(node);
        } else if (!queue2.isEmpty()) {
            queue2.addLast(node);
        }
    }

    // 按照先入后出的顺序弹出元素
    public static int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("栈为空，无法弹出元素！");
        }
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.addLast(queue1.removeFirst());
            }
            return queue1.removeFirst();
        } else {
            while (queue2.size() > 1) {
                queue1.addLast(queue2.removeFirst());
            }
            return queue2.removeFirst();
        }
    }
}


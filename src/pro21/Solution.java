package pro21;

import java.util.Stack;
/**
 * @author linazhu
 * @Description 包含min函数的栈，min、push、pop的时间复杂度都是O(1)
 */

/**
 * 思路：
 * 不能只保存一个最小元素，因为最小元素弹出后，无法找到次小元素
 * 辅助栈：每压入一个元素到数据栈，相应的压入一个最小元素到辅助栈
 * 保持辅助栈栈顶永远是现有的最小元素，并且辅助栈的元素个数与数据栈的元素个数相同
 * 当一个元素压入数据栈时，如果该元素大于目前最小元素，则将现在的最小元素再次压入辅助栈
 */
public class Solution {
    // 数据栈
    Stack<Integer> dataStack = new Stack<>();
    // 辅助栈
    Stack<Integer> minStack = new Stack<>();

    // 压入元素
    public void push(int node) {
        dataStack.push(node);
        if (minStack.size() == 0 || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    // 弹出元素
    public void pop() {
        if (dataStack.size() == 0 || minStack.size() == 0) {
            return;
        }
        dataStack.pop();
        minStack.pop();
    }

    // 返回栈顶的元素，不删除该元素
    public int top() {
        if (dataStack.size() == 0 || minStack.size() == 0) {
            throw new RuntimeException("栈为空，无法弹出元素");
        }
        return dataStack.peek();
    }

    // 返回栈中的最小元素
    public int min() {
        if (minStack.size() == 0) {
            throw new RuntimeException("栈为空，无最小元素");
        }
        return minStack.peek();
    }
}

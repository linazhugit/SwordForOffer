package pro07;

import java.util.Stack;

/**
 * @author linazhu
 * @Description
 */
/**
 * 用两个堆栈实现队列
 * 1. 插入时统一插入stack1中
 * 2. 删除元素：
 * 若stack2中没有元素则将stack1中的元素弹出到stack2中，再从stack2中弹出元素
 * 若stack2中有元素则直接从stack2中弹出元素
 */
public class Solution {
	private static Stack<Integer> stack1 = new Stack<>();
	private static Stack<Integer> stack2 = new Stack<>();

	// 插入元素到队尾
	public static void push(int node) {
		stack1.push(node);
	}

	// 按照先入先出的顺序弹出头元素
	public static int pop() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		} else {
			// 将stack1中的元素弹出到stack2
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		// 将stack1中的元素压入stack2后，若stack2仍为空，则无法弹出头元素
		if (stack2.isEmpty()) {
			throw new RuntimeException("队列为空，无法删除！");
		}
		return stack2.pop();

	}
}

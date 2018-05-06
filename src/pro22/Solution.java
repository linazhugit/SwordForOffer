package pro22;

import java.util.Stack;
/**
 * @author linazhu
 * @Description 栈的压入、弹出序列
 */

/**
 * 思路：
 * 按照入栈顺序，将元素一次压入栈，在压入元素的同时：
 * 如果下一个弹出的数字正好是栈顶的数字，则弹出元素；
 * 如果下一个弹出的元素不在栈顶，就把压栈序列中还没有入栈的数字压入辅助栈，直达把下一个数字压入栈顶为止；
 * 如果所有的数字都压入栈了，仍然没有找到下一个弹出的数字，那么该序列不是一个弹出序列
 */
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        // 边界检查
        if (pushA == null || popA == null || pushA.length <= 0
                || popA.length <= 0) {
            return false;
        }
        Stack<Integer> dataStack = new Stack<>();
        // number表示已压入栈的元素数目，用于判定元素压入是否已经完成
        int number = 0;
        for (int i = 0; i < popA.length; i++) {
            // 如果下一个弹出的数字正好是栈顶的数字，则弹出元素；
            if (!dataStack.isEmpty() && dataStack.peek() == popA[i]) {
                dataStack.pop();
            } else {
                // 如果所有的数字都压入栈了，仍然没有找到下一个弹出的数字，那么该序列不是一个弹出序列
                if (number == pushA.length) {
                    return false;
                }
                // 如果下一个弹出的元素不在栈顶，就把压栈序列中还没有入栈的数字压入辅助栈，直达把下一个数字压入栈顶为止；
                else {
                    do
                        dataStack.push(pushA[number++]);
                    while (dataStack.peek() != popA[i] && number < pushA.length);
                    // 上面这个循环有两个结束条件
                    if (dataStack.peek() == popA[i]) {
                        dataStack.pop();
                    } else {
                        return false;
                    }

                }
            }

        }
        return true;
    }
}

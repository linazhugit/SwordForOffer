package pro05;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author linazhu
 * @Descripiton 输入一个链表的头结点 实现从尾到头打印链表
 */
public class Solution {

    public static ArrayList<Integer> printListFromTailToHead(ListNode headNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while (headNode != null) {
            stack.push(headNode);
            headNode = headNode.next;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }
        return result;
    }
}

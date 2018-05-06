package pro13;

/**
 * @author linazhu
 * @Description 给定单向链表的头指针和一个结点，定义一个函数在O(1)时间删除该结点
 */

/**
 * 思路：
 * 要删除的结点为i；i的下一个结点为j
 * 把结点j的内容复制覆盖结点i，把结点i的下一个结点指向j的下一个结点，删除结点j
 * 边界：
 * ① 要删除的结点是尾结点：只能顺序遍历，找到尾结点的上一个结点再删除尾结点
 * ② 如果链表只有一个节点：删除后要将头结点置为NULL
 * 注意：所写程序的前提是，要删除的结点一定在该链表中；因为判断结点是否在链表中的时间复杂度是O(N)
 */
public class Solution {
    public static void deleteNode(ListNode head, ListNode deleteListNode) {
        if (head == null || deleteListNode == null) {
            throw new RuntimeException("链表或删除结点不能为NULL");
        }
        // 要删除的结点不是尾结点，则删除这个结点的下一个结点
        if (deleteListNode.next != null) {
            ListNode pNext = deleteListNode.next;
            deleteListNode.val = pNext.val;
            deleteListNode.next = pNext.next;
            pNext = null;
        }
        // 链表中只有一个节点，即要删除的结点
        else if (head == deleteListNode) {
            deleteListNode = null;
            head = null;
        }
        // 链表中有多个结点，要删除的结点是尾结点
        else {
            // 顺序遍历，找到要删除结点的上一个结点
            ListNode pointNode = head;
            while (pointNode.next != deleteListNode) {
                pointNode = pointNode.next;
            }
            pointNode.next = null;
            pointNode = null;
        }

    }
}

package pro16;

/**
 * @author linazhu
 * @Description 翻转链表
 */

/**
 * 思路：
 * 需要三个指针，分别指向当前遍历到的指针，它的前一个结点和后一个结点
 * 保存前一个结点是因为翻转后，前一个结点变为下一个结点
 * 保存后一个结点是为了防止翻转后链表断开
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // pHead是翻转后的头结点
        ListNode pHead = null;
        ListNode preNode = null;
        ListNode pNode = head;
        ListNode nextNode = null;
        while (pNode != null) {
            nextNode = pNode.next;
            // 翻转之前的尾结点为翻转后的头结点
            if (nextNode == null) {
                pHead = pNode;
            }
            // 修改链表的方向
            pNode.next = preNode;
            // 移动到下一个结点
            preNode = pNode;
            pNode = nextNode;
        }
        return pHead;
    }
}

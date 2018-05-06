package pro37;

/**
 * @author linazhu
 * @Description 两个链表的第一个公共结点
 */

/**
 * 思路：
 * 1. 链表是单链表
 * 2. 如果两个单向链表有公共结点，那么从第一个公共结点开始，之后所有结点都是重合的，不可能再出现分叉
 * 3. 有公共结点的两个链表的拓扑结构为Y型，不能是X型
 * 思路1：空间复杂度O(m+n) 时间复杂度O(m+n)
 * 从两个链表的尾部开始比较，最后一个相同的结点就是要找的结点。
 * 利用栈，实现从链表的尾部开始查找。
 * 思路2：时间复杂度O(m+n)，空间复杂度O(1)
 * 1. 遍历两个链表，得到链表长度，两个链表的长度差
 * 2. 在长的链表上先移动差值部分的，然后两个链表一起向后移动，第一个相同的结点就是要找的结点
 */
public class Solution {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = 0;
        int length2 = 0;
        ListNode pNode1 = pHead1;
        ListNode pNode2 = pHead2;
        while (pNode1 != null) {
            length1++;
            pNode1 = pNode1.next;
        }
        while (pNode2 != null) {
            length2++;
            pNode2 = pNode2.next;
        }
        // 两个链表的长度差
        int difLength = length1 - length2;
        // 长链表的头结点
        ListNode pLongNode = pHead1;
        // 短链表的头结点
        ListNode pShortNode = pHead2;
        if (length2 > length1) {
            difLength = length2 - length1;
            pLongNode = pHead2;
            pShortNode = pHead1;
        }
        // 长链表的指针先移动difLength长度
        for (int i = 0; i < difLength; i++) {
            pLongNode = pLongNode.next;
        }
        // 长短链表一起移动，找相同结点
        while ((pLongNode != null) && (pShortNode != null)
                && (pLongNode != pShortNode)) {
            pLongNode = pLongNode.next;
            pShortNode = pShortNode.next;
        }
        return pLongNode;
    }
}

package pro17;

/**
 * @author linazhu
 * @Description 合并两个已排序的链表
 */

/**
 * 思路：
 * 比较两个链表的头结点的大小，找到小的一个，作为合并后链表的结点，再递归
 */
public class Solution {
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode pMergedHead;
        if (list1.val < list2.val) {
            pMergedHead = list1;
            pMergedHead.next = merge(list1.next, list2);
        } else {
            pMergedHead = list2;
            pMergedHead.next = merge(list1, list2.next);
        }
        return pMergedHead;
    }
}

package pro16_1;

/**
 * @author linazhu
 * @Description 判断一个单链表是否形成了环形结构
 */

/**
 * 思路：
 * 定义两个指针，同时从链表的头结点出发，一个指针一次走一步，另一个指针一次走两步；
 * 如果走得快的指针追上走的慢的指针，就有环形结构；如果走的快的指针走到链表的末尾(NULL)仍没有追上，则不是环形链表
 */
public class Solution {
    public static boolean isCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode pANode = head;
        ListNode pBNode = head;
        while (pANode != null && pBNode != null) {
            pANode = pANode.next;
            if (pBNode.next == null) {
                return false;
            }
            pBNode = pBNode.next.next;
            // 比较两个结点是否相同，来判断快的指针是否追上了慢的指针
            if (pANode == pBNode) {
                return true;
            }
        }
        return false;
    }
}

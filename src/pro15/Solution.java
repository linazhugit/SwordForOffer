package pro15;


/**
 * @author linazhu
 * @Description 链表倒数第K个节点，链表尾结点为倒数第一个结点
 */

/**
 * 思路：
 * 两个指针，第一个指针从链表的头指针开始遍历向前走K-1步
 * 从第K步开始，第二个指针也开始从链表的头指针开始遍历
 * 两个指针的距离保持在K-1，当第一个指针到达链表的尾结点时，第二个指针正好是第K-1个结点
 * 注意点：
 * 链表的总结点数可能小于输入的K，所以在第一个指针向前走K-1步时，每次都需要判断下一个结点是否为null
 * 因为链表尾结点为倒数第一个结点，所以不存在倒数第0个结点
 */
public class Solution {
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            throw new RuntimeException("输入参数异常，请检查！");
        }
        ListNode pANode = head;
        ListNode pBNode = head;
        // 第一个指针向前走k-1步
        for (int i = 0; i < k - 1; i++) {
            if (pANode.next != null) {
                pANode = pANode.next;
            } else {
                // 总结点数小于K，倒数第K个结点不存在，返回null
                return null;
            }
        }
        // 两个指针保持k-1步的距离同时向前走，当指针一到达结尾时，指针B指向倒数第K个结点
        while (pANode.next != null) {
            pANode = pANode.next;
            pBNode = pBNode.next;
        }
        return pBNode;
    }
}

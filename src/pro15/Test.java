package pro15;

/**
 * @author linazhu
 * @Description 链表倒数第K个节点，链表尾结点为倒数第一个结点
 */
public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();
        head.next = second;
        second.next = third;
        third.next = forth;
        head.val = 1;
        second.val = 2;
        third.val = 3;
        forth.val = 4;
        ListNode resultListNode = Solution.findKthToTail(head, 3);
        if (null != resultListNode) {
            System.out.println(resultListNode.val);
        }

    }
}

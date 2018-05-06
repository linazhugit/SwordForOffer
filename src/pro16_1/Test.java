package pro16_1;

/**
 * @author linazhu
 * @Description 判断一个单链表是否形成了环形结构
 */

public class Test {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        System.out.print(Solution.isCycle(node1));
    }

}

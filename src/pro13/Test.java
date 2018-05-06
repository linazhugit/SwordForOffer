package pro13;

/**
 * @author linazhu
 * @Description 给定单向链表的头指针和一个结点，定义一个函数在O(1)时间删除该结点
 */
public class Test {
	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode second = new ListNode();
		ListNode third = new ListNode();
		head.next = second;
		second.next = third;
		head.val = 1;
		second.val = 2;
		third.val = 3;
		Solution.deleteNode(head, second);
		System.out.println(head.next.val);
	}
}

package pro05;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author linazhu
 * @Desctiption 从尾到头打印链表
 */
public class Test {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		ArrayList<Integer> result = Solution.printListFromTailToHead(node1);
		for (Iterator<Integer> iterator = result.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		for (Integer i : result) {
			System.out.println(i);
		}
	}

}

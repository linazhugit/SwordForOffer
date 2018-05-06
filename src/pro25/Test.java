package pro25;

import java.util.ArrayList;
import java.util.Iterator;


public class Test {
	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(10);
		BinaryTreeNode node1 = new BinaryTreeNode(5);
		BinaryTreeNode node2 = new BinaryTreeNode(12);
		BinaryTreeNode node3 = new BinaryTreeNode(4);
		BinaryTreeNode node4 = new BinaryTreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		ArrayList<ArrayList<Integer>> paths = Solution.FindPath(root, 22);
		for (ArrayList<Integer> path : paths) {
			for (Iterator<Integer> iterator = path.iterator(); iterator
					.hasNext();) {
				System.out.print(iterator.next() + ";");
			}
		}
	}
}

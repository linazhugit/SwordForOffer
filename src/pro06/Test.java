package pro06;


/**
 * @author linazhu
 * @Description 重建二叉树
 */
public class Test {

    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        BinaryTreeNode root;
        try {
            root = Solution.reConstructBinaryTree(pre, in);
            System.out.println(root.val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

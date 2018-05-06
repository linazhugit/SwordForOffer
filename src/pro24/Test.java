package pro24;

/**
 * @author linazhu
 * @Description 二叉搜索树的后序遍历序列
 */
public class Test {
    public static void main(String[] args) {
        int[] sequence = {5, 6, 8};
        boolean result = Solution.VerifySquenceOfBST_1(sequence);
        System.out.print(result);
    }
}

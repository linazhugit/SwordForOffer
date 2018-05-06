package pro24;

import java.util.Arrays;
/**
 * @author linazhu
 * @Description 二叉搜索树的后序遍历序列
 */

/**
 * 思路：
 * 根节点在最后，找到根节点，把数组分为两部分，大于根节点的是右子树，小于根节点的是左子树
 * 左右子树递归
 */
public class Solution {
    public static boolean VerifySquenceOfBST_1(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int i = 0;
        // 遍历数组，找到左右子树元素分界点的下标
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        System.out.println("分界点i是：" + i);
        int j = i;
        // 右子树的结点大于根节点
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        // 判断左子树是不是二叉搜索树；i=0说明只有右子树，此时左子树为空，是二叉搜索树
        boolean left = true;
        if (i > 0) {
            left = VerifySquenceOfBST_1(Arrays.copyOfRange(sequence, 0, i));
        }

        // 判断右子树是不是二叉搜索树；i=length-1说明只有左子树，此时右子树为空，是二叉搜索树
        boolean right = true;
        if (i < length - 1) {
            right = VerifySquenceOfBST_1(Arrays.copyOfRange(sequence, i,
                    length - 1));
        }
        return (left && right);
    }

    // 方法二不明白cut为什么需要加1；设计不太合理，主要还是看方法一
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int cut = 0;
        // 遍历数组，找到左右子树元素分界点的下标
        for (int i = 0; i < length - 1; i++) {
            if (sequence[i] > root) {
                cut = i + 1;
                break;
            }
        }
        if (cut == 0) {
            // 只有左子树
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, length - 1));
        } else {
            // 右子树的结点大于根节点
            for (int j = cut; j < length - 1; j++) {
                if (sequence[j] < root) {
                    return false;
                }
            }
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, cut - 1));
            VerifySquenceOfBST(Arrays
                    .copyOfRange(sequence, cut - 1, length - 1));
        }
        return true;
    }
}

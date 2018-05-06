package pro36;

/**
 * @author linazhu
 * @Description 数组中的逆序对
 */

/**
 * 思路：
 * 利用归并排序
 * 1. 先把数组分为子数组，先统计出子数组内部的逆序对数，然后再统计出两个相邻子数组之间的逆序对数。
 * 2. 在统计逆序对的过程中，还要对数组进行排序
 */
public class Solution {

    public int inversePairs(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        // 空间复杂度O(n)
        int[] tmpArray = new int[array.length];
        // 初始化临时数组的值和原数组相同
        for (int i = 0; i < array.length; i++) {
            tmpArray[i] = array[i];
        }
        int count = inversePairs(array, 0, array.length - 1, tmpArray);
        tmpArray = null;
        return count;
    }

    private int inversePairs(int[] array, int left, int right, int[] tmpArray) {
        if (left == right) {
            tmpArray[left] = array[left];
            return 0;
        }
        int center = (left + right) / 2;
        // left和right分别表示左半部分数组和右半部分数组中的逆序对
        // ！！！！！特别注意，次数交换了array和tmpArray两个数组，tmpArray数组中已排序部分是有序的，避免了merge部分将已排序部分从临时数组拷贝到原数组的操作
        int leftCount = inversePairs(tmpArray, left, center, array);
        int rightConut = inversePairs(tmpArray, center + 1, right, array);
        // 统计左半部分数组和右半部分数组合并时的逆序对数，需要倒序遍历两个数组
        int leftPos = center;
        int rightPos = right;
        int tmpPos = right;
        // 逆序对数
        int count = 0;
        while (leftPos >= left && rightPos >= center + 1) {
            if (array[leftPos] > array[rightPos]) {
                tmpArray[tmpPos--] = array[leftPos--];
                // rightPos指向第二个数组（右边数组）中的第几个元素，就有几个逆序对
                count += rightPos - center;
            } else {
                tmpArray[tmpPos--] = array[rightPos--];
            }
        }
        while (leftPos >= left) {
            tmpArray[tmpPos--] = array[leftPos--];
        }
        while (rightPos >= center + 1) {
            tmpArray[tmpPos--] = array[rightPos--];
        }
        return leftCount + count + rightConut;
    }
}

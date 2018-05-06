package pro14;

/**
 * @author linazhu
 * @Description 调整数组，使奇数在偶数前面
 */

/**
 * 思路：
 * 两个指针分别指向数组的开头和结尾，从开头向后遍历查找偶数元素，
 * 从结尾向前遍历查找奇数元素，交换前面的偶数元素和后面的奇数元素
 * 负面测试：输入数组为null；输入数组中只有一个元素
 */
public class Solution {
    public static void reOrderArray(int[] array) {
        int length = array.length;
        if (length == 0) {
            throw new NullPointerException("传入的数组不能为null");
        }
        if (length == 1) {
            return;
        }
        int start = 0;
        int end = length - 1;
        while (start < end) {
            // 从前向后遍历，找到一个偶数元素
            while (start < end && (array[start] & 0x1) != 0) {
                start++;
            }
            // 从后向前遍历，找到一个奇数元素
            while (start < end && (array[end] & 0x1) == 0) {
                end--;
            }
            // 交换前面的偶数元素和后面的技术元素
            if (start < end) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }
    }
}

package pro34;

/**
 * @author linazhu
 * @Description 第1500个丑数
 */

/**
 * 丑数：只包含因子2、3、5的数
 * 思路：
 * 1. 遍历每一个数字，判断是不是丑数，一直到找到1500个丑数，时间效率不高。
 * 2. 将已有的丑数按顺序存入数组，然后根据已有的丑数乘以2、3和5找到后续的丑数。
 * 3. 记录一个下标分界线，分界线之前的元素乘以2之后小于数组中已有的最大丑数，分界线之后的元素乘以2之后大于数组中已有的最大丑数
 */
public class Solution {

    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        // 额外的内存空间，用于保存丑数
        int[] numbers = new int[index];
        // 第一个丑数
        numbers[0] = 1;
        // 下一个丑数在数组中的下标，当前数组中已有丑数的个数
        int nextIndex = 1;
        // 目前数组中最大的丑数
        int currentMax = 1;
        // 下标，在t2下标之前的数组元素乘以2后，小于目前数组的最大值，在t2下标之后的数组元素乘以2之后大于目前数组的最大值
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;

        // 当前数组中的丑数元素，通过乘以2、3或者5得到下一个丑数元素中的最小值，就是可以放入数组的下一个元素
        int min = 1;
        while (nextIndex < index) {
            min = min(numbers[t2] * 2, numbers[t3] * 3, numbers[t5] * 5);
            numbers[nextIndex] = min;
            currentMax = numbers[nextIndex];
            // 此处等号是重点！目的是生成比当前数组中最大丑数还要大的数，所以等号的时候要向前移动
            while (numbers[t2] * 2 <= currentMax) {
                t2++;
            }
            while (numbers[t3] * 3 <= currentMax) {
                t3++;
            }
            while (numbers[t5] * 5 <= currentMax) {
                t5++;
            }
            nextIndex++;
        }
        return numbers[nextIndex - 1];
    }

    // 找到三个数字中的最小值
    private static int min(int num1, int num2, int num3) {
        int min = (num1 < num2) ? num1 : num2;
        min = (min < num3) ? min : num3;
        return min;
    }
}

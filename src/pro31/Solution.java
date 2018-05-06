package pro31;
/**
 * @author linazhu
 * @Description 连续子数组的最大和
 */

/**
 * 如果累加子数组的和小于0，则抛弃前面的数组元素，因为前面的数组元素对子数组累加和没有任何有效的贡献
 */
public class Solution {

    public static int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0) {
            throw new RuntimeException("输入参数无效！");
            // return 0;
        }
        int currentSum = 0;
        // maxsum不能初始化为0；因为有可能最后的最大连续子数组之和为负数
        int maxSum = 0x80000000;
        for (int i = 0; i < array.length; i++) {
            if (currentSum <= 0) {
                currentSum = array[i];
            } else {
                currentSum += array[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}

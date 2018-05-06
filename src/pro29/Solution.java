package pro29;
/**
 * @author linazhu
 * @Description 数组中出现超过一半的数
 */

/**
 * 思路：
 * 遍历数组时保存两个值：一个是数组中的一个数字，一个是次数
 * 遍历下一个数字时：
 * ① 如果下一个数字和之前保存的数字相同，则次数加1；
 * ② 如果下一个数字和之前保存的数字不相同，则次数减1
 * ③ 如果次数为0，需要保存下一个数字
 * 注意：总体思路就是两个不同的数字会导致次数清零。
 * 输入的数组中，可能不存在次数过半的数，所以找到合适的元素后，要进行次数验证。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            // throw new RuntimeException("输入数组错误，请检查！");
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        // 判断找到的元素是否出现次数超过数组长度的一半
        if (checkMoreThanHalf(array, result)) {
            return result;
        } else {
            // 返回0表示输入数组中找不到出现次数大于一半的元素
            return 0;
        }

    }

    private boolean checkMoreThanHalf(int[] array, int result) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                times++;
            }
        }
        if (times << 2 <= array.length) {
            return false;
        } else {
            return true;
        }
    }
}

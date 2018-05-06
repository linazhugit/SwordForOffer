package pro30;

import java.util.ArrayList;
/**
 * @author linazhu
 * @Description 最小的K个数
 */

/**
 * 1. 输入数组可以修改时的算法，时间复杂度为O(n)
 * 2. 输入数组不可以修改时的算法，时间复杂度是O(nlogk)；适合处理海量数据
 * 思路
 * 基于数组的第K个数字来调整，调整完成后，位于数组中左边的K个数字就是最小的K个数字，这K个数字不是排序的
 * 类似于快速排序的实现思路
 */
public class SolutionI {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length <= 0 || k <= 0 || k > input.length) {
            return result;
        }
        int length = input.length;
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, length, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, length, start, end);
            } else {
                start = index + 1;
                index = partition(input, length, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    // 选取基准元素
    public static int partition(int[] data, int length, int start, int end) {
        if (data == null || length <= 0 || start < 0 || end >= length) {
            throw new RuntimeException("输入参数无效！");
        }
        int index = (start + end) / 2;
        // 交换随机生成数下标对应元素和最后一个元素
        swap(data, index, end);
        // index是随机生成的主元的下标，若index位于排序后的正确位置，则index前面应该有index个元素比它小
        // small指向数组中小于参考值的最后一个，index指向数组中大于参考值的第一个
        int small = start - 1;
        for (index = start; index < end; index++) {
            // 遍历数组元素，如果找到比基准元素小的元素，就交换到前面
            // small表示下一个比基准元素小的元素可以交换到的下标
            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }
        small++;
        swap(data, small, end);
        return small;
    }

    // 交换两个元素
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

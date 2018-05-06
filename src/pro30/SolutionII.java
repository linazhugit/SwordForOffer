package pro30;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author linazhu
 * @Description 最小的K个数
 */

/**
 * 思路：
 * 1. 建立一个大小为k的数据容器
 * 遍历数组：如果元素大于容器中的最大值，则不做任何处理
 * 如果元素小于容器中的最大值，需要删除容器中的最大值，再插入被遍历到的这个元素
 * 2. 数据容器的选择
 * 最大堆，在O(1)时间内找到最大值，在O(logK)时间进行插入和删除
 */
public class SolutionII {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length <= 0 || k <= 0 || k > input.length) {
            return result;
        }
        // 根据输入数组[0,k-1]元素建立最大堆
        int[] kArray = Arrays.copyOfRange(input, 0, k);
        buildMaxHeap(kArray);
        // 从下标K开始遍历数组，与最大堆的根节点比较，若大于根节点则舍去，若小于根节点则重排最大堆
        for (int i = k; i < input.length; i++) {
            if (input[i] < kArray[0]) {
                kArray[0] = input[i];
                maxHeap(kArray, 0);
            }
        }
        for (int i = 0; i < kArray.length; i++) {
            result.add(kArray[i]);
        }
        return result;
    }

    // 建立最大堆 局部自上而下下滑调整 局部是自底向上的 而且局部的范围逐渐变大
    private static void buildMaxHeap(int[] kArray) {
        // i=0为根节点，最后进行调整，调整完成后，整个
        for (int i = kArray.length / 2; i >= 0; i--) {
            maxHeap(kArray, i);
        }
    }

    // 重排堆，保持最大堆的特性
    public static void maxHeap(int[] array, int i) {
        int left = 2 * i + 1;
        int right = left + 1;
        int max = 0;
        // 比较传入的结点和它的左右儿子结点，max用于保存三者中最大的一个的下标
        if (left < array.length && array[left] > array[i]) {
            max = left;
        } else {
            max = i;
        }
        if (right < array.length && array[right] > array[max]) {
            max = right;
        }
        // 将传入的结点和它的左右儿子结点中最大的一个交换到传入结点的位置
        if (max != i) {
            int tmp = array[i];
            array[i] = array[max];
            array[max] = tmp;
            // 递归
            maxHeap(array, max);
        }

    }
}

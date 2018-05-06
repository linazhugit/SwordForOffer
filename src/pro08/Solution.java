package pro08;


/**
 * @author linazhu
 * @Description 旋转数组的最小数字
 */
/**
 * 思路：
 * 一个排序数组通过旋转分成两部分，每部分都是一个排序数组，每个排序数组都是递增的
 * 第一个数组的最小元素大于第二个数组的最大元素
 * 思路：二分查找，最终找到两个数组的交界处
 * ① 两个指针分别指向数组的第一个元素和最后一个元素
 * ② 找到两个指针的中间元素
 * 若该元素大于第一个元素，则位于第一个数组中，将第一个指针移动到中间元素
 * 若该元素小于最后一个元素，则位于第二个数组中，将第二个指针移动到中间元素
 * ③ 直到两个指针相差1，并且第一个指针元素大于第二个指针元素时，即找到交界处和最大最小元素
 * 特别注意：
 * ① 将排序数组前面0个元素旋转到最后，即数组本身是排序的，数组第一个元素就是最小元素
 * 判断数组的第一个元素是否小于最后一个元素，若小于说明已经是排好序的数组，第一个元素就是最小元素
 * ② 数组中存在重复元素导致中间元素等于第一个指针和第二个指针，此时无法判断最小元素在哪一个排序数组中，必须使用顺序查找
 */
public class Solution {
	public static int minNumberInRotateArray(int[] array) {
		if (array == null) {
			throw new RuntimeException("输入排序数组错误！");
		}
		if (array.length == 0) {
			return 0;
		}
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		int midIndex = 0;
		// if (array[leftIndex] < array[rightIndex]) { return array[midIndex]; }
		while (array[leftIndex] >= array[rightIndex]) {
			// 找到两个排序数组的交界处
			if (rightIndex - leftIndex == 1) {
				midIndex = rightIndex;
				break;
			}
			midIndex = (leftIndex + rightIndex) / 2;
			if (array[leftIndex] == array[rightIndex]
					&& array[leftIndex] == array[midIndex]) {
				// 顺序查找
				return minInOrder(array, leftIndex, rightIndex);
			}
			if (array[midIndex] >= array[leftIndex]) {
				leftIndex = midIndex;
			} else if (array[midIndex] <= array[rightIndex]) {
				rightIndex = midIndex;
			}
		}

		return array[midIndex];
	}
	// 在某个区间中顺序查找最小元素
	private static  int minInOrder(int[] array, int leftIndex, int rightIndex) {
		int result = array[leftIndex];
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (result > array[i]) {
				result = array[i];
			}
		}
		return result;
	}
}

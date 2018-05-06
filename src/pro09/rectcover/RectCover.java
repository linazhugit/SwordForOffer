package pro09.rectcover;

/**
 * @author linazhu
 * @Description 矩形覆盖
 */
/**
 * 思路：递归解决
 * 既然是长条形的，那么从后向前，最后一个矩形2*2的，只有两种情况：
 * 第一种是最后是由一个2*(n-1)的矩形加上一个竖着的2*1的矩形
 * 另一种是由一个2*(n-2)的矩形，加上两个横着的2*1的矩形
 * 因此我们可以得出，第2*n个矩形的覆盖方法等于第2*(n-1)加上第2*(n-2)的方法。
 * 注意：2*(n-2)的矩形不能加上两个竖着的2*1的矩形，因为这种排列方式与第一种情况中重复
 */
public class RectCover {
	public static int rectCover(int target) {
		if (target < 0) {
			return 0;
		}
		int[] result = new int[target + 10];
		result[0] = 1;
		result[1] = 1;
		result[2] = 2;
		for (int i = 3; i <= target; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[target];
	}
}

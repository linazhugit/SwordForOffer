package pro12;

/**
 * @author linazhu
 * @Description 打印1到最大的n位数
 */

/**
 * 思路：
 * 注意：n可能非常大，需要考虑大数问题；大数问题可以使用字符串或数组来解决
 * 该题目有两种实现思路
 * 1. 在数上加1逐个打印，需要每次判断是否到最大数，这个是关键
 * 2. n位所有十进制数其实就是n个从0到9的全排列，打印的时候不需要打印排在前面的无效的0
 */
public class Solution {
	public static void printToMaxOfNDigits(int n) {
		if (n <= 0) {
			throw new RuntimeException("输入位数出错，请重新检查！");
		}
		// 用数组解决大数问题
		byte[] array = new byte[n];
		printHelpRecursive(array, n, 0);
	}

	// 用全排列的方法打印所有数字；实现方法是递归
	// from result[0] to result[n-1],set 0-9 into it
	public static void printHelpRecursive(byte[] result, int length, int index) {
		if (index == length) {
			printNumber(result);
		} else {
			for (byte i = 0; i <= 9; i++) {
				// 设置一个数的最高位，然后递归设置低位，直到达到这个数的总位数
				result[index] = i;
				printHelpRecursive(result, length, index + 1);
			}
		}
	}

	// 打印数组，不要打印数字左侧无效的0
	public static void printNumber(byte[] re) {
		int len = re.length;
		boolean canPrint = false;
		for (byte i = 0; i < len - 1; i++) {
			if (!canPrint && re[i] != 0) {
				canPrint = true;
			}
			if (canPrint) {
				System.out.print(re[i]);
			}
		}
		// 最后一位即最低位总是要打印的，即使是0
		System.out.println(re[len - 1]);
	}

}

package pro11;

/**
 * @author linazhu
 * @Description 数值的整数次方
 */

/**
 * 思路：
 * 边界：整数次方包括正整数次方，0次方和负整数次方，负整数次方通过取绝对值求整数次方再求倒数来实现，0次方若底数不为0，则为0
 * 负面：0的小于等于0次方，会出现异常
 * 效率：通过递归来求n次方，时间复杂度由O(N)降低到O(logN)；右移代替除法；&0x1判断奇偶
 * 特别注意：不能直接用==判断float和double是否相等，当两个小数差的绝对值很小时，即认为相等。
 */
public class Solution {
	public double power(double base, int exponent) {
		double result = 0.0;
		// 负面测试
		if (equals(base, 0.0) && exponent < 0) {
			throw new RuntimeException("0的负数次幂无意义！");
		}
		// 边界测试--0次幂
		if (exponent == 0) {
			result = 1.0;
			return result;
		}
		// 功能测试--负数次幂
		if (exponent < 0) {
			result = powerWithExponent(1.0 / base, -exponent);
		} else {
			result = powerWithExponent(base, exponent);
		}
		return result;
	}

	// 通过递归求一个数的n次幂
	private double powerWithExponent(double base, int exponent) {

		if (exponent == 1) {
			return base;
		}
		// 递归，通过右移代替除法，提升效率
		double result = powerWithExponent(base, exponent >> 1);
		result *= result;
		// exponent为奇数时，a^n=a^((n-1)/2)*a^((n-1)/2)^a
		if ((exponent & 0x1) == 1) {
			result *= base;
		}
		return result;
	}

	// 判断两个double小数是否相等
	private boolean equals(double num1, double num2) {
		if ((num1 - num2 > -0.0000001) && (num1 - num2) < 0.0000001) {
			return true;
		} else {
			return false;
		}
	}
}

package pro09.jump;

/**
 * @author linazhu
 * @Description 青蛙跳台阶
 */

/**
 * 思路：
 * 最后一个台阶的方法数目可以由前面计算出来。那么，仔细想一下，一个青蛙只能跳1-2步，也就是说，
 * 最后一个台阶肯定是由它的前一个台阶或者前两个台阶上去的（假设这个时候台阶数目很长）。
 * 那么很显然，到达最后一个台阶的方法数目等于前一个台阶的方法数目加上前两个台阶的方法数目，到这里我们发现这是一个很典型的斐波那契数列。
 */
public class JumpFloor {
	public static int jumpFloor(int target) {
		int num1 = 1;
		int num2 = 2;
		int num3 = 0;
		if (target <= 0) {
			throw new RuntimeException("台阶数目错误！");
		} else if (target <= 2) {
			return target;
		}
		for (int i = 3; i <= target; i++) {
			num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
		}
		return num3;
	}
}

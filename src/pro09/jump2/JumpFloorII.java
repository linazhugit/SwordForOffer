package pro09.jump2;

/**
 * @author linazhu
 * @Description 变态跳台阶
 */

/**
 * 思路：
 * 和跳台阶一样，到第n级台阶，
 * 可以从第 1级，第2级，......第n-2级，第n-1级直接跳到第n级，也可以从第0级直接跳到第n级。
 * f[n] = f[1] + f[2] + ...... f[n-2] + f[n-1] + 1
 */
public class JumpFloorII {
    public static int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        // 使用递归
        return 2 * jumpFloor(target - 1);

    }
}

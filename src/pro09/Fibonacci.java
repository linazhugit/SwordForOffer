package pro09;
/**
 * @author linazhu
 * @Description 斐波那契数列
 */

/**
 * 递归的算法用循环实现
 */
public class Fibonacci {
    public int fibonacci(int n) {
        // 初始化
        int result[] = {0, 1};
        if (n < 2) {
            return result[n];
        }
        int fib1 = 0;
        int fib2 = 1;
        int fibn = 0;
        for (int i = 2; i <= n; i++) {
            // 记录计算中间项，避免重复计算
            fibn = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibn;
        }
        return fibn;
    }
}

package pro10;

/**
 * @author linazhu
 * @Description 二进制中1的个数
 */

/**
 * 思路：
 * 1. 把一个整数减去1，都是把该整数最右边的1变为0，如果右边还有0的话，所有的0都变为1，左边所有位不变；
 * 2. 把一个整数减去1，再和原来的整数做与运算，会把该整数最右边的一个1变成0；使1的个数减1。
 */
public class Solution {
    // 按位遍历，时间复杂度与二进制的位数相关
    public int solution_1(int n) {
        int flag = 1;
        int count = 0;
        // flag为int类型，经过32次左移后，flag为0
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // 时间复杂度只与二进制中1的位数相关
    public int solution_2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}

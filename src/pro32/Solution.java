package pro32;

/**
 * @author linazhu
 * @Description 从1到n整数中1出现的次数
 */

/**
 * 思路：
 * 从各位开始，分别求每一位上1出现的次数，时间复杂度是O(logK)
 * 注意：
 * 1. 每一位出现1的个数都与当前位的数字、高位的数字和低位的数字相关
 * 2. 每一位都有权重，个位的权重为1，十位的权重为10
 * 举例说明
 * 103十位出现1的个数：10-19 共1*10=10个
 * 213十位出现1的个数：10-19 110-119 210-213 共2*10+3+1=24个
 * 223十位出现1的个数：10-19 110-119 210-219 共(2+1)*10=30个
 */
public class Solution {

    public int numberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int result = 0;
        // 当前位，从个位开始，一直到最高位
        int currentNum = 0;
        int lowerNum = 0;
        int higherNum = 0;
        int factor = 1;
        while (n / factor != 0) {
            lowerNum = n - n / factor * factor;
            // 通过n / factor舍掉当前位右边的低位数字，
            currentNum = (n / factor) % 10;
            // 通过n / (factor * 10)舍掉了包括当前位在内的右半部分的低位，得到当前位的高位
            higherNum = n / (factor * 10);
            switch (currentNum) {
                case 0:
                    result += higherNum * factor;
                    break;
                case 1:
                    result += higherNum * factor + lowerNum + 1;
                    break;
                default:
                    result += (higherNum + 1) * factor;
                    break;
            }
            // 取出下一个高位数字
            factor *= 10;
        }
        return result;
    }
}

package pro28;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @author linazhu
 * @Description 字符串的排列
 */

/**
 * 思路：
 * 首先任意选择一个字符在第一位，共有n种选择方法；
 * 在剩余的n-1个字符中任意选择一个字符在第二位，共有n-1中选择方法
 * ......
 * 注意：递归解决问题
 * 第一步：求所有可能出现在第一个位置的字符，即把第一个字符和后面所有字符交换。
 * 第二步：固定第一个字符，求后面所有字符的排列。将后面所有字符分为第一个字符和之后的字符，递归进行解决。
 * index表示每次排列时第一个字符的索引，后面的字符可以和index字符交换。
 */
public class Solution {
    static ArrayList<String> result = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {

        if (str == null || str.length() == 0) {
            return result;
        }
        char[] src = str.toCharArray();
        permutation(src, 0);
        // 结果按照字典排序
        Collections.sort(result);
        return result;
    }

    private static void permutation(char[] src, int index) {
        if (index == src.length) {
            if (!result.contains(String.valueOf(src))) {
                result.add(String.valueOf(src));
            }
        } else {
            for (int i = index; i < src.length; i++) {
                // 所有可能出现在index位置的字符；i和index交换
                char tmp = src[i];
                src[i] = src[index];
                src[index] = tmp;

                permutation(src, index + 1);
                // i和index的交换再交换回去
                tmp = src[i];
                src[i] = src[index];
                src[index] = tmp;
            }
        }
    }
}

package pro28_1;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * @author linazhu
 * @Description 字符串的组合
 */

/**
 * 思路：
 * 1. 输入n个字符，这n个字符能够组成长度为1的组合，长度为2的组合，。。。，长度为n的组合
 * 2. 求n个字符组成的长度为m(1<=m<=n)的组合时：把n个字符分为两部分，第一个字符和其余所有字符；
 * 我们有两种选择：一是把第一个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选取m-1个字符；
 * 二是不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m个字符。这两种选择都很容易用递归实现。
 * 即：
 * 求n个字符长度为m的组合问题分解为两个子问题，分别求n-1字符串中长度为m-1的组合；以及求n-1个字符的长度为m的组合
 * C(n,m) = C(n-1,m) + C(n-1,m-1)
 */
public class Solution {
    static ArrayList<String> results = new ArrayList<>();

    public static ArrayList<String> combination(String str) {
        if (str == null) {
            return results;
        }
        int length = str.length();
        LinkedList<Character> tmp = new LinkedList<>();
        char[] src = str.toCharArray();
        // i表示生成组合中字符的个数
        for (int i = 1; i <= length; i++) {
            combination(src, 0, i, tmp);
        }
        return results;
    }

    /**
     * @param src    src是输入的n个字符
     * @param index  index表示从输入n个字符的第几个字符开始挑选加入组合的元素
     * @param number number表示某个长度的组合中还缺少的字符个数
     * @param tmp    用于保存一个组合
     */
    private static void combination(char[] src, int index, int number,
                             LinkedList<Character> tmp) {
        if (number == 0) {
            int tmpLen = tmp.size();
            char[] result = new char[tmpLen];
            for (int i = 0; i < tmpLen; i++) {
                result[tmpLen - 1 - i] = tmp.get(i);
            }
            results.add(new String(result));
            return;
        }
        if (index != src.length) {
            tmp.push(src[index]);
            combination(src, index + 1, number - 1, tmp);
            tmp.pop();
            combination(src, index + 1, number, tmp);
        }
    }
}

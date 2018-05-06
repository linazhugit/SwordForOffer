package pro33;

import java.util.Comparator;
import java.util.TreeSet;
/**
 * @author linazhu
 * @Description 把数组排成最小的数
 */

/**
 * 思路：
 * 两个数字m和n能拼接成数字mn和nm，如果mn<nm，定义m<n
 * 利用TreeSet，根据上面的原则自定义Comparator；TreeSet输出时，是由小到大的顺序
 * 使用StringBuilder将整数连接成字符串，再利用字符串的比较规则去比较两个字符串的大小即可。
 * 特别注意：
 * 如果第一个数字是1，第二个数字是11，拼接成字符串之后，两个都是111，如果只用字符串的大小比较大小，
 * 这两个字符串相同，会导致11这个数字不能存入TreeSet
 */
public class Solution {

    public String printMinNumber(int[] numbers) {
        String result = new String();
        if (numbers == null || numbers.length <= 0) {
            return result;
        }
        TreeSet<Integer> treeSet = new TreeSet<>(new ComparatorByNumber());
        // 遍历数组中的元素，加入TreeSet
        for (int i = 0; i < numbers.length; i++) {
            treeSet.add(numbers[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历TreeSet中的元素，取出并拼接为字符串
        for (Integer i : treeSet) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    class ComparatorByNumber implements Comparator<Integer> {
        StringBuilder merge1;
        StringBuilder merge2;

        @Override
        public int compare(Integer i1, Integer i2) {
            merge1 = new StringBuilder();
            merge2 = new StringBuilder();
            merge1.append(i1).append(i2);
            merge2.append(i2).append(i1);
            return (merge1.toString().compareTo(merge2.toString()) == 0) ? 1
                    : merge1.toString().compareTo(merge2.toString());
        }
    }
}

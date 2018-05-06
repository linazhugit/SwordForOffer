package pro35;

import java.util.HashMap;

/**
 * @author linazhu
 * @Description 寻找第一个只出现一次的字符
 */
public class SolutionII {

    // 方法二 用HashMap实现哈希表的功能
    // 返回值为第一次只出现一次的字符在原字符串中的位置
    public static int firstNotRepeatingChar(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        char[] src = str.toCharArray();
        // 遍历输入字符串，统计每个字符出现的次数
        HashMap<Character, Integer> tmp = new HashMap<>();
        for (int i = 0; i < src.length; i++) {
            if (tmp.containsKey(src[i])) {
                tmp.put(src[i], tmp.get(src[i]) + 1);
            } else {
                tmp.put(src[i], 1);
            }
        }
        // 遍历字符串，找到第一个次数为1的字符
        for (int i = 0; i < src.length; i++) {
            if (tmp.get(src[i]) == 1) {
                return i;
            }
        }
        // 没有只出现一次的字符，返回-1
        return -1;
    }
}

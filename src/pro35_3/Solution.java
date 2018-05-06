package pro35_3;

/**
 * @author linazhu
 * @Description 判断两个单词是否是互为变位词
 */

/**
 * 变位词的特点：单词中出现的字符相同并且字符出现的次数也相同
 */
public class Solution {

    public boolean isAnagram(String str1, String str2) {
        if (str1 == null || str1.length() <= 0 || str2 == null
                || str2.length() <= 0) {
            return false;
        }
        char[] src1 = str1.toCharArray();
        char[] src2 = str2.toCharArray();
        // 哈希表，存储第一个字符串中出现的字符级次数
        byte[] charCounts = new byte[256];
        // 遍历第一个字符数组，统计出现的字符和次数
        for (int i = 0; i < src1.length; i++) {
            // 将字符出现的次数加1
            charCounts[src1[i]]++;
        }
        // 遍历第二个字符数组，判断是否与第一个字符数组相同
        for (int i = 0; i < src2.length; i++) {
            // 将字符出现的次数减1
            charCounts[src2[i]]--;
        }
        // 遍历哈希表，如果有的字符次数不是0，则不是变位词
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

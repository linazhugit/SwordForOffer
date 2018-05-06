package pro35;

/**
 * @author linazhu
 * @Description 寻找第一个只出现一次的字符
 */

/**
 * 思路：
 * 1. 用一个char[256]数组存放字符出现的次数，字符的ASCII码值为数组的下标，对应的值为该字符出现的次数。
 * 比如array[97]就是字符a出现的次数
 * 2. 第一次扫描字符串时，每扫描一个字符就在字符数组中将对应项加次数加1；统计每个字符出现的次数
 * 3. 第二次扫描字符数组，找到第一个出现次数为1的字符。
 * 注意：字符串中可能不存在只出现一次的字符
 */
public class SolutionI {

    // 方法一 用数组实现哈希表的功能
    public static int firstNotRepeatingChar(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        char[] array = new char[256];
        char[] src = str.toCharArray();
        // 遍历输入字符串，统计每个字符出现的次数
        for (int i = 0; i < src.length; i++) {
            array[src[i]]++;
        }
        // 扫描统计次数的数组，这个方法是错误的，因为gatyuityui这个中第一次出现一次的字符本来应该是g但是这种扫描方法得到的是a
//		for (int i = 0; i < array.length; i++) {
//			if (array[i] == 1) {
//				// 返回值为字符的ASCII值
//				return i;
//			}
//		}
        for (int i = 0; i < src.length; i++) {
            if (array[src[i]] == 1) {
                // 返回第一次出现一次字符的下标值
                return i;
                // 如果返回是字符
//				return src[i];
            }
        }
        // 没有只出现一次的字符，返回-1
        return -1;
    }

}

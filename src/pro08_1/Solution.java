package pro08_1;

/**
 * @author linazhu
 * @Description 年龄排序
 */
/**
 * 思路：
 * 首先统计每个年龄有多少人；
 * 根据统计结果，重置排序数组
 */
public class Solution {
    public static void sortAges(int ages[], int length) {
        if (ages == null || length <= 0) {
            return;
        }
        int oldestAge = 99;
        // timesOfAge用于统计每个年龄出现的次数
        int timesOfAge[] = new int[oldestAge + 1];
        int tmpAge;
        // 遍历数组，统计每个年龄出现的次数
        for (int i = 0; i < length; i++) {
            tmpAge = ages[i];
            if (tmpAge < 0 || tmpAge > oldestAge) {
                throw new RuntimeException("输入的年龄超出范围！");
            }
            timesOfAge[tmpAge]++;
        }
        // 根据统计结果，重置数组，实现排序
        int index = 0;
        for (int i = 0; i < oldestAge; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                ages[index] = i;
                index++;
            }
        }
    }
}

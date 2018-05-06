package pro28_3;

/**
 * @author linazhu
 * @Description 八皇后问题
 */

/**
 * 思路：
 * 每个皇后单独占一行，单独占一列：定义一个数组ColumnIndex[8]，数组中第i个数字表示位于第i行的皇后列号。
 * 把数组ColumnIndex[8]的8个数字用0-7初始化(保证任意两个皇后不同列)，再进行全排列。
 * 在全排列中选择任意两个皇后不在同一对角线上的情况
 * i-j==ColumnIndex[i]-ColumnIndex[j]或者j-i==ColumnIndex[i]-ColumnIndex[j]
 */
public class Solution {
    public static final int queens = 8;
    public static int solutions = 0;

    public static void eightQueen() {
        int[] columnIndex = {0, 1, 2, 3, 4, 5, 6, 7};
        permutation(columnIndex, 0);
    }

    private static void permutation(int[] columnIndex, int index) {
        if (index == columnIndex.length) {
            if (check(columnIndex)) {
                solutions++;
                printQueen(columnIndex);
            }
        } else {
            for (int i = index; i < columnIndex.length; i++) {
                // 所有可能出现在index位置的字符；i和index交换
                int tmp = columnIndex[i];
                columnIndex[i] = columnIndex[index];
                columnIndex[index] = tmp;

                permutation(columnIndex, index + 1);
                // i和index的交换再交换回去
                tmp = columnIndex[i];
                columnIndex[i] = columnIndex[index];
                columnIndex[index] = tmp;
            }
        }
    }

    // 判断某一个排列是否符合规则
    private static boolean check(int[] columnIndex) {
        // 皇后需要进行两两比较
        for (int i = 0; i < columnIndex.length; i++) {
            for (int j = i + 1; j < columnIndex.length; j++) {
                if ((i - j == columnIndex[i] - columnIndex[j])
                        || (j - i == columnIndex[i] - columnIndex[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printQueen(int[] columnIndex) {
        System.out.println("solutions: " + solutions);
        for (int i = 0; i < columnIndex.length; i++) {
            System.out.print(columnIndex[i]);
        }
        System.out.println();
    }

}

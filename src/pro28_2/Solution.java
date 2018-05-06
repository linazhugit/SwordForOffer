package pro28_2;
/**
 * @author linazhu
 * @Description 8个数字分别放到正方体的8个顶点上，使得正方体上三组相对面上的4个顶点的和都相等
 */

/**
 * 思路：
 * 先得到a1--a8这8个数字的全排列
 * 在全排列中选择符合条件的排列：
 * a1+a2+a3+a4 = a5+a6+a7+a8
 * a1+a3+a5+a7 = a2+a4+a6+a8
 * a1+a2+a5+a6 = a3+a4+a7+a8
 */
public class Solution {
    public static int solutions = 0;

    public static void solution(int[] array) {
        permutation(array, 0);
    }

    private static void permutation(int[] array, int index) {
        if (index == array.length) {
            if (check(array)) {
                solutions++;
                printQueen(array);
            }
        } else {
            for (int i = index; i < array.length; i++) {
                // 所有可能出现在index位置的字符；i和index交换
                int tmp = array[i];
                array[i] = array[index];
                array[index] = tmp;

                permutation(array, index + 1);
                // i和index的交换再交换回去
                tmp = array[i];
                array[i] = array[index];
                array[index] = tmp;
            }
        }
    }

    // 判断某一个排列是否符合规则
    private static boolean check(int[] array) {
        if ((array[0] + array[1] + array[2] + array[3] == array[4] + array[5]
                + array[6] + array[7])
                && (array[0] + array[2] + array[4] + array[6] == array[1]
                + array[3] + array[5] + array[7])
                && (array[0] + array[1] + array[4] + array[5] == array[2]
                + array[3] + array[6] + array[7])) {
            return true;

        }
        return false;
    }

    private static void printQueen(int[] array) {
        System.out.println("solutions: " + solutions);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

}

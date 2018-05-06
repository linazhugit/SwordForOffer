package pro20;

import java.util.ArrayList;
/**
 * @author linazhu
 * @Description 顺时针打印矩阵
 */

/**
 * 思路:
 * 1. 第一圈起点坐标(0,0)；第二圈起点坐标(1,1)；第三圈起点坐标(2,2)；
 * 2. 矩阵的行列数与打印圈数之间的关系
 * 因为除最后一圈外，每打印一圈，至少需要两行和两列
 * 圈号从0开始，则需要满足行数大于圈号*2并且列数大于圈号*2
 * 3. 顺时针打印一圈，分为四步
 * 第一步：从左到右打印一行
 * 第二步：从上到下打印一列，前提：终止行号大于起始行号
 * 第三步：从右到左打印一行，前提：终止行号大于起始行号并且终止列号大于起始列号
 * 第四步：从下到上打印一列，前提：终止行号比起始行号至少大2并且终止列号大于起始列号
 */
public class Solution {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        // 用于存储每一圈打印的数字
        ArrayList<Integer> tmp;
        if (matrix == null) {
            return null;
        }
        int rows = matrix.length;
        if (rows <= 0) {
            return null;
        }
        int columns = matrix[0].length;
        if (columns <= 0) {
            return null;
        }
        // 圈号
        int start = 0;
        while (rows > start * 2 && columns > start * 2) {
            tmp = printMatrixInCircle(matrix, rows, columns, start);
            start++;
            result.addAll(tmp);
        }
        return result;
    }

    private static ArrayList<Integer> printMatrixInCircle(int[][] matrix, int rows,
                                                   int columns, int start) {
        ArrayList<Integer> result = new ArrayList<>();
        // 每打印一圈，终止的X坐标要减掉1，因为最右侧少了一列
        // 终止列号
        int endX = columns - 1 - start;
        // 终止行号
        int endY = rows - 1 - start;
        // 从左到右打印一行
        for (int i = start; i <= endX; i++) {
            int number = matrix[start][i];
            result.add(number);
        }
        // 从上到下打印一列，前提：终止行号大于起始行号
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int number = matrix[i][endX];
                result.add(number);
            }
        }
        // 从右到左打印一行，前提：终止行号大于起始行号并且终止列号大于起始列号
        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; i--) {
                int number = matrix[endY][i];
                result.add(number);
            }
        }
        // 从上到下打印一列，前提：终止行号比起始行号至少大2并且终止列号大于起始列号
        if (start < endY - 1 && start < endX) {
            for (int i = endY - 1; i > start; i--) {
                int number = matrix[i][start];
                result.add(number);
            }
        }
        return result;
    }
}

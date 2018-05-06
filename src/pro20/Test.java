package pro20;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author linazhu
 * @Description 顺时针打印矩阵
 */
public class Test {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        ArrayList<Integer> result = Solution.printMatrix(matrix);
        for (Iterator<Integer> iterator = result.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + ";");
        }
    }
}

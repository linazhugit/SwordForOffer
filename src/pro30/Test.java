package pro30;

import java.util.ArrayList;

/**
 * @author linazhu
 * @Description 最小的K个数
 */
public class Test {
    public static void main(String[] args) {
        int[] array = {5, 6, 8, 2, 3, 45, 12, 62, 52};
        ArrayList<Integer> result = SolutionII.GetLeastNumbers_Solution(array, 2);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}

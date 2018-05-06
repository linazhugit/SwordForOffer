package pro14;

/**
 * @author linazhu
 * @Description 调整数组，使奇数在偶数前面
 */

public class Test {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        Solution.reOrderArray(array);
        for (int i : array)
            System.out.println(i);
    }

}

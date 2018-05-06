package pro08_1;

/**
 * @author linazhu
 * @Description 年龄排序
 */
public class Test {

    public static void main(String[] args) {
        int[] ages = {5, 5, 5, 2, 2, 2, 6, 5, 8, 8, 9, 4, 6, 88, 22, 55, 77,
                88, 22};
        Solution.sortAges(ages, ages.length);
        for (int i : ages) {
            System.out.print(i + ";");
        }
    }

}

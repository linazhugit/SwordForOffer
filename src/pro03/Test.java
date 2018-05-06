package pro03;
/*
 * 38 数字查找
 * [6][5]表示六行五列的数组，即有六个一维数组，每个一维数组中有五个元素
 * 获取数组的行数：array.length;获取数组的列数：array[0].length
 */

/**
 * @author linazhu
 * @Description 38 数字查找
 * [6][5]表示六行五列的数组，即有六个一维数组，每个一维数组中有五个元素
 * 获取数组的行数：array.length;获取数组的列数：array[0].length
 */
public class Test {

    public static void main(String[] args) {
        int[][] array = new int[4][4];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 8;
        array[0][3] = 9;
        array[1][0] = 2;
        array[1][1] = 4;
        array[1][2] = 9;
        array[1][3] = 12;
        array[2][0] = 4;
        array[2][1] = 7;
        array[2][2] = 10;
        array[2][3] = 13;
        array[3][0] = 6;
        array[3][1] = 8;
        array[3][2] = 11;
        array[3][3] = 15;
        System.out.println(Solution.find(array, 9));
    }

}

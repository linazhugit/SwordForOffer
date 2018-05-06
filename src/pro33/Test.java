package pro33;

import java.util.TreeSet;

/**
 * @author linazhu
 * @Description 测试比较器Comparator是否正确
 */
public class Test {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(new ComparatorByMergeNumber());
        treeSet.add(1);
        treeSet.add(11);
        treeSet.add(111);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : treeSet) {
            stringBuilder.append(i);
            System.out.println(i);
        }
        System.out.println(stringBuilder.toString());
    }
}

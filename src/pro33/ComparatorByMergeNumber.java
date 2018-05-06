package pro33;

import java.util.Comparator;

/**
 * @author linazhu
 * @Description 比较器
 */

public class ComparatorByMergeNumber implements Comparator<Integer> {
    private StringBuilder merge1;
    private StringBuilder merge2;

    @Override
    public int compare(Integer i1, Integer i2) {
        merge1 = new StringBuilder();
        merge2 = new StringBuilder();
        merge1.append(i1).append(i2);
        merge2.append(i2).append(i1);

        return (merge1.toString().compareTo(merge2.toString()) == 0) ? 1
                : merge1.toString().compareTo(merge2.toString());
    }

}

package pro28;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author linazhu
 * @Description 字符串的排列
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> result = Solution.Permutation("abc");
        for (Iterator<String> iterator = result.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}

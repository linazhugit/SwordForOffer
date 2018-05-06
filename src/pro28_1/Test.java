package pro28_1;

import java.util.ArrayList;

/**
 * @author linazhu
 * @Description 字符串的组合
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> results = Solution.combination("abc");
        for (String result : results) {
            System.out.println(result);
        }
/*		String s1 = "abc";
		char[] tmp = s1.toCharArray();
		for (int i = 0; i < tmp.length; i++) {
			System.out.println(tmp[i]);
		}
		
		char[] array = {'1','2','3'};
		System.out.println(new String(array));*/

    }
}

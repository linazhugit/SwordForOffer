package pro35;

/**
 * @author linazhu
 * @Description 寻找第一个只出现一次的字符
 */
public class Test {
	public static void main(String[] args) {
		char result = (char) SolutionI.firstNotRepeatingChar("gbyuiyui");
		System.out.println(result);
		int index = SolutionII.firstNotRepeatingChar("abcdabd");
		System.out.println(index);
	}
}

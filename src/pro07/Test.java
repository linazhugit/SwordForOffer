package pro07;


/**
 * @author linazhu
 * @Description 用两个栈实现队列
 */
public class Test {
    public static void main(String[] args) {
        Solution.push(1);
        Solution.push(2);
        Solution.push(3);
        Solution.push(4);
        Solution.push(5);
        for (int i = 0; i < 5; i++) {
            int tmp = Solution.pop();
            System.out.println(tmp);
        }
    }
}

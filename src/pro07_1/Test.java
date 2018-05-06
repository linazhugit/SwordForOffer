package pro07_1;

/**
 * @author linazhu
 * @Description 用两个栈实现队列 方式二
 */
public class Test {
    public static void main(String[] args) {
        int tmp;
        Solution.push(1);
        Solution.push(2);
        Solution.push(3);
        tmp = Solution.pop();
        System.out.println(tmp);// 3
        Solution.push(4);
        tmp = Solution.pop();
        System.out.println(tmp);// 4
        tmp = Solution.pop();
        System.out.println(tmp);// 2
        Solution.push(5);
        Solution.push(6);
        tmp = Solution.pop();
        System.out.println(tmp);// 6
        tmp = Solution.pop();
        System.out.println(tmp);// 5
        tmp = Solution.pop();
        System.out.println(tmp);// 1
    }
}

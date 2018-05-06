package pro09.jump;

/**
 * @author linazhu
 * @Description 青蛙跳台阶
 */
public class Test {

    public static void main(String[] args) {
        int num = 15;
        int i = JumpFloor.jumpFloor(num);
        System.out.print("台阶数目：" + num + "；跳法：" + i);
    }

}

package pro02;

/**
 * @author linazhu
 * @Description double-check单例模式
 */
public class Singleton {

    // 私有化构造函数
    private Singleton() {
    }

    // 静态私有成员变量
    private volatile static Singleton singleton;

    // 获取实例的方法
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    // volatile屏蔽指令重排序
                    // 1. 在内存中分配一块内存
                    // 2. 调用构造方法
                    // 3. 将内存地址指向singleton变量，执行完这一步后singleton!=null
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}

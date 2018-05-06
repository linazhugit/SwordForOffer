package pro02;

/**
 * @author linazhu
 * @Description 静态内部类实现单例模式
 */
public class SingletonII {
    private SingletonII() {

    }

    public static SingletonII getInstance() {
        return SingletonInstance.instance;
    }

    // 静态内部类
    private static class SingletonInstance {
        private static final SingletonII instance = new SingletonII();
    }
}

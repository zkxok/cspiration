https://blog.csdn.net/itachi85/article/details/50510124

https://www.runoob.com/design-pattern/singleton-pattern.html

//1.懒汉式
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}  
//2.饿汉式
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}  
//3.双重检查锁
public class Singleton {
    private volatile static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return singleton;
    }
}
//4.静态内部类式
public class Singleton {
    private Singleton() {}
    public static Singleton getInstance() {
        return SingletonHolder.sInstance;
    }
    private static class SingletonHolder {
        private static final Singleton sInstance = new Singleton();
    }
} 
//5.枚举单例
public enum Singleton {
    INSTANCE;
    public void doSomeThing() {
    }
} 
//6.容器单例
public class SingletonManager {
    private static Map<String, Object> objMap = new HashMap<String, Object>();
    private Singleton() {}
    public static void registerService(String key, Object instance) {
　　　　if (!objMap.containsKey(key)) {
　　　　　　objMap.put(key, instance);
　　　　}
　　}
    public static Object getService(String key) {
　　　　return objMap.get(key);
　　}
}


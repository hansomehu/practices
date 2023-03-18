package lang.juc;

public class DCLSingleton {
    /*
    安全单例模式 Double Check Lock
     */

    private static volatile DCLSingleton instance = null;

    public DCLSingleton() {
        System.out.println("Instantiated...");
    }

    public static DCLSingleton getInstance(){
        if (instance == null){

            // double check
            synchronized (DCLSingleton.class){
                if (instance == null){
                    instance = new DCLSingleton();
                }
            }
        }

        return instance;
    }
}

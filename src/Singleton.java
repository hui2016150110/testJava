public class Singleton {
    private static volatile Singleton instance;
    private Singleton(){

    }
    public static Singleton getInstance(){
        return SingletonHolder.sInstance;
    }
    private static class SingletonHolder{
        private static final Singleton sInstance = new Singleton();

    }
}

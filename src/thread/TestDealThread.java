package thread;

public class TestDealThread {
    public static void main(String[] args){
        try {
            DealThread t1 = new DealThread();
            t1.setFlag("a");
            Thread thread1 = new Thread(t1);
            thread1.start();
            Thread.sleep(100);
            t1.setFlag("b");
            Thread thread2 = new Thread(t1);
            thread2.start();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

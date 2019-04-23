package thread;

public class TestSleep {
    public static void main(String[] args){

        Alipay alipay = new Alipay(5,600);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                alipay.setCount();

            }
        });

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                alipay.setCount();
            }
        });

        thread2.start();
    }
}

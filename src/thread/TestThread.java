package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread implements Runnable{
    private static Alipay alipay;
    private int from;
    private int to;
    private int amount;
    private String name;
    public TestThread(int from,int to,int amount,String name){
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.name = name;

    }
    public static void main(String[] args) throws InterruptedException {

        alipay = new Alipay(6,500);
        TestThread acc3 = new TestThread(2,3,60,"thread3");
        Thread thread3 = new Thread(acc3);
        thread3.start();

        TestThread acc1 = new TestThread(3,2,1000,"thread1");
        Thread thread1 = new Thread(acc1);
        thread1.start();

        Thread.sleep(1000);
//        System.out.println(alipay.getAccounts()[2]);
//        System.out.println(alipay.getAccounts()[3]);
//
        TestThread acc4 = new TestThread(2,3,60,"thread4");
        Thread thread4 = new Thread(acc4);
        thread4.start();
//
//
//        TestThread acc2 = new TestThread(2,3,60,"thread2");
//        Thread thread2 = new Thread(acc2);
//        thread2.start();




    }

    @Override
    public void run() {

        try {
            alipay.transfer(from,to,amount,name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

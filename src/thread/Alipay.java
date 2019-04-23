package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Alipay {
    private double[] accounts;
    private Condition condition;
    private Lock lock;
    public int count = 0;

    public Alipay(int n,double money){
        accounts = new double[n];
        lock = new ReentrantLock();
        condition = lock.newCondition();
        for(int i = 0;i<accounts.length;i++){
            accounts[i] = money;
        }

    }

    public void transfer(int from,int to,int amount,String name)throws InterruptedException{
        lock.lock();
        try{
            while (accounts[from]<amount){
                System.out.println("waiting");
                condition.await();
            }
            accounts[from] = accounts[from]-amount;
            accounts[to] = accounts[to]+amount;
            condition.signalAll();
            System.out.println("success");
            System.out.println(name);
        }finally {
            lock.unlock();
        }
    }

    public double[] getAccounts() {
        return accounts;
    }

    synchronized public void setCount(){
        for(int i = 0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(count+" "+Thread.currentThread().toString());
        }
    }
}

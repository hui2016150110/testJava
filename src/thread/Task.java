package thread;

import java.util.concurrent.Callable;

class Task implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("子线程在计算");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = 0;
        for(int i = 0;i<=100;i++){
            sum+=i;
        }
        System.out.println("子线程结束了");
        return sum;
    }
}

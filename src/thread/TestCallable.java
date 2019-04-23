package thread;

import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executorService.submit(task);
        executorService.shutdown();

        Thread.sleep(1000);
        System.out.println("主线程在运行");
        System.out.println("子线程的计算结果："+result.get());
        System.out.println("主线程在执行完毕");
    }

}


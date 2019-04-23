package thread;

public class TestStudent2 {
    public static void main(String[] args) throws InterruptedException {
        Student student1 = new Student(1,"a");
        Student student2 = new Student(2,"b");
        student1.setGrades(100);
        student2.setGrades(100);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                student1.addGrades(100);
                System.out.println("当前线程"+Thread.currentThread().getName());
            }
        });
        thread.setName("thread1");
        thread.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                student2.addGrades(100);
                System.out.println("当前线程"+Thread.currentThread().getName());
            }
        });
        thread2.setName("thread2");
        thread2.start();
    }
}

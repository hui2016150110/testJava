package thread;

public class DealThread implements Runnable{
    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();
    public void setFlag(String name){
        this.username = name;
    }

    @Override
    public void run() {
        if(username.equals("a")){
            synchronized (lock1){
                try {
                    System.out.println("username:"+username);
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("lock1->lock2");
                }
            }

        }
        if(username.equals("b")){
            synchronized (lock2){
                try {
                    System.out.println("username:"+username);
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("lock2->lock1");
                }
            }

        }
    }
}

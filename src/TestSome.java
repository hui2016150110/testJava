import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class TestSome {
    public static void main(String[] args){

       
    }
    class Task implements Callable<Integer>{
        @Override
        public Integer call() {
            System.out.println();
            return null;
        }
    }
}


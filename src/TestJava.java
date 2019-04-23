import baseSet.set.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestJava {

    Child1 child1 = new Child1("child1");

    Child2 child2 = new Child2("child2");
    public static void main(String[] args) {


        TestJava test =  new TestJava();
        //test.testThreadLocal();
        test.testFather(test.child1,test.child2);

    }
    public void testThreadLocal(){
        ThreadLocal<Boolean> booleanThreadLocal = new ThreadLocal<>();
        ThreadLocal<ArrayList<String>> threadLocal = new ThreadLocal<>();

        booleanThreadLocal.set(true);
        System.out.println(booleanThreadLocal.get());
        new Thread("thread1"){
            @Override
            public void run() {
                booleanThreadLocal.set(false);
                System.out.println("thread1:"+booleanThreadLocal.get());

            }
        }.start();

        new Thread("thread2"){
            @Override
            public void run() {
                System.out.println("thread2:"+booleanThreadLocal.get());
            }
        }.start();
    }

    public void testFather(Father child1,Father child2){
            if(child1.getClass()==child2.getClass()){
                System.out.println("相等");
            }else {
                System.out.println("不相等");
            }
            if(child1.getClass()==Father.class){
                System.out.println("和父类相等");
            }else {
                System.out.println("和父类不相等");
            }
            if(child1.getClass()==Child1.class){
                System.out.println("和本类相等");
            }
    }
}

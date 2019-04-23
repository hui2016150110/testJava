package baseSet.list;

import java.util.*;

public class TestArrayList {
    public static void main(String[] args){
        String a = new String("aaaa");
        String b = new String("aaaa");
        String c = a;
        System.out.println(a==c);
        a.hashCode();
        System.out.println(new Node("lll").hashCode());
        System.out.println(new Node("lll").hashCode());
        System.out.println("bbbb"+b.hashCode());
        Set set = new HashSet();
        set.add(a);
        set.add(b);
        Integer i = new Integer(20);
        Integer j = new Integer(20);
        set.add(i);
        set.add(j);
        Node node = new Node("llll");
        set.add(new Node("kkk"));
        set.add(new Node("kkk"));
        System.out.print("node"+node.hashCode());
        new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println("node"+node.hashCode());
            }
        }).start();
    }
    static class Node{
        private String name;
        public Node(String name){
            this.name = name;
        }
    }
}

package thread;

public class Student {
    public int id;
    public String name;
    public static float grades;
    public Student(int id,String name){
        this.id = id;
        this.name = name;
        this.grades = 0;
    }

    public void setGrades(float grades) {
        this.grades = grades;

    }
    synchronized public static void addGrades(float grades1){
        grades+=grades1;
        System.out.println("执行addGrades，当前线程"+grades);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void addGrades2(float grades){
        this.grades+=grades;
        System.out.println("执行addGrades2，当前线程"+this.grades);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

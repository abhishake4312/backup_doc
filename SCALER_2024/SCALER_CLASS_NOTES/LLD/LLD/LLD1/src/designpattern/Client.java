package designpattern;

public class Client {
    public static void main(String[] args) {
        Course c=new Course();
        c.method(30,"abhi");
        Course c1=new Course();
        c1.method(40,"ram");
        System.out.println(Course.student.age);
    }
}

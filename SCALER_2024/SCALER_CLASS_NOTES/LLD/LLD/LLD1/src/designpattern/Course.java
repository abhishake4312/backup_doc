package designpattern;

public class Course {
    String name;
    static Student student;

    void method(int age,String name){
        student =new Student(age,name);
    }
}

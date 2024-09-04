package prototype;

public class Parent {

    private int age;
    private String name;
    public Parent(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
    public static void main(String[] args) {
        Parent p=new Child(20,"abhishek",98);
        System.out.println(p.age);
    }
}

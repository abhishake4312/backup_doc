package Inheritance;

public class Student extends User{
	
	Student(String name){
		super(name);
		System.out.println("child constructor");
	//	super("abhishek");
	}
	public static void main(String[] args){
		Student s =new Student("abhi");
	}

}

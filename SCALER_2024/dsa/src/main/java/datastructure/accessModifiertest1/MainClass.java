package datastructure.accessModifiertest1;

public class MainClass {

	
	public static void main(String[] args){
		Student s1=new Student();
		s1.age=10;
		s1.name="abhi";
		System.out.println("s1 age "+s1.age);
		System.out.println("s1 name " +s1.name);
		Student s2=new Student(s1);
		System.out.println("s2 age "+s2.age);
		System.out.println("s2 name " +s2.name);
		
		s2.name="ravi";
		System.out.println("s1 name " +s1.name);
		System.out.println("s2 name " +s2.name);
	}
}

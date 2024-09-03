package datastructure.accessModifiertest1;

public class Student {
	
	String name;
	int age;
	Student(){		
	}
	
	Student(Student s){
		this.name=s.name;
		this.age=s.age;
	}
	
	public static void main(String[] args){
		Student s1=new Student();
		s1.age=10;
		s1.name="abhi";
		System.out.println("s1 age "+s1.age);
		System.out.println("s1 name " +s1.name);
		Student s2=new Student(s1);
		System.out.println("s2 age "+s2.age);
		System.out.println("s2 name " +s2.name);
		
	//	s2.name="ravi"; //changing name of s2 is not affecting name of s1 that means 
		                //it is not pointing to same object
		s1.name.concat("ram");
		System.out.println("s1 name " +s1.name);
		System.out.println("s2 name " +s2.name);
	}

}

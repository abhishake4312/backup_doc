package Inheritance;

public class User {

	String name;
	String email;
	
//	User(){
//		System.out.println("Parent no arg Constructor");
//		
//	}
	User(String name){
		System.out.println("Parent 1 param cons");
		this.name=name;
	}
	User(String name,String email){
		System.out.println("Parent 2 param cons");
		this.name=name;
		this.email=email;
	}
}

package datastructure.parentChildSuper;

public class Child extends Parent{
	
	Child(int a){
		super(3);
		System.out.println("Child constructor");
	}
	void method(){
		System.out.println("Child");
	}
}

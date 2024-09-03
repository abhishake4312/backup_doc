package datastructure.recursion;

import java.util.ArrayList;

public class PassByReference {

	static void func(Integer count){
		count=1;  
	}
	static void func2(String s){
		
		s="raj"; //creates a new object raj and s points to that object
	}
	public static void main(String[] args){
		
		Integer count=0;
		func(count);       
		System.out.println(count);
		
		String s="ram";
		func2(s);
		System.out.println(s); //because String is immutable 
		
	}

}

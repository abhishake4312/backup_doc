package datastructure;

import java.io.*;
import java.util.*;


	public class PrefixToPostfix {

	
	public static void main (String[] args) {
	// INPUT -- 	*-A/BC-/AKL
	// OUTPUT -- 	ABC/-AK/L-*
		Scanner sc = new Scanner(System.in);
		String prefix = sc.next();
		String postfix = preToPost(prefix);
		System.out.println(postfix);
	}
	
	public static String preToPost(String prefix){
	    Stack<String> s =new Stack<String>();
	    int l= prefix.length();
	    for(int i=l-1;i>=0;i--){
	        char c= prefix.charAt(i);
	        if(Character.isLetterOrDigit(c)){
	            s.push(c+"");
	        }
	        else{
	            String first=s.pop();
	            String second = s.pop();
	            String operation = first+second+c;
	            s.push(operation);
	        }
	    }
	    return s.pop();
	}
}
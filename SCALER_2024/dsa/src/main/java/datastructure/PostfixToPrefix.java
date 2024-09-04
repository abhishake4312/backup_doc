package datastructure;

import java.util.Stack;

public class PostfixToPrefix {

	public static void main(String[] args) {
		String postfix="ABC/-AK/L-*";
		String prefix = postToPre(postfix);
		//output *-A/BC-/AKL
		System.out.println(prefix);
	}
	public static String postToPre(String postfix) {
		Stack<String> s= new Stack<String>();
		int l = postfix.length();
		for(int i=0;i<l;i++) {
			char c= postfix.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				s.push(c+"");
			}else {
		
				String first=s.pop();
				
		
				String second=s.pop();
				
				String operation = c+second+first;
				s.push(operation);
			}
		}
		return s.pop();
	}
}

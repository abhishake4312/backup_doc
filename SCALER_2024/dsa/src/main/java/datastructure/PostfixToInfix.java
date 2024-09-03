package datastructure;

import java.util.Stack;

public class PostfixToInfix {

	public static void main(String[] args) {
		String postfix = "abc++";
		String infix= postToInfix(postfix);
		System.out.println(infix);
	}
	public static String postToInfix(String postfix) {
		Stack<String> s =new Stack<String>();
		int l = postfix.length();
		for(int i=0;i<l;i++) {
			char c = postfix.charAt(i);
			if(isOperator(c)) {
				String first = s.pop();
				String second = s.pop();
				String operation = "("+second+c+first+")";
				s.push(operation);
			}else {
				s.push(c+"");
			}
		}
		
		return s.pop();
	}
	
	public static boolean isOperator(char c) {
		if(c=='/'|| c=='*' || c=='+' || c=='-') {
			return true;
		}else {
			return false;
		}
	}
}

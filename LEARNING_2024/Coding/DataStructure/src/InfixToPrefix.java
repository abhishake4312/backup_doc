import java.util.Stack;

public class InfixToPrefix {

	public static void main(String[] args) {
		
		String infix=" (A+B)*(C-D)";
		//output *+AB-CD
		String prefix = infixToPrefix(infix);
		System.out.println(prefix);
	}
	public static String infixToPrefix(String infix) {
		
		Stack<Character> s= new Stack<Character>();
		int l = infix.length();
		String revInfix="";
		for(int i=l-1;i>=0;i--) {
			char c=infix.charAt(i);
			if(c=='(') {
				revInfix=revInfix+')';
			}else if(c==')') {
				revInfix=revInfix+'(';
			}
			else {
				revInfix=revInfix+c;
			}
			
		}
		String prefix="";
		for(int i=0;i<l;i++) {
	    	char c= revInfix.charAt(i);
	    
	    	if(Character.isLetterOrDigit(c)) {
	    		prefix=prefix+c;
	    	}
	    	else if (c=='(') {
	    		s.push(c);
	    	}
	    	else if (c==')') {
	    		while(!s.isEmpty() && s.peek()!='(') {
	    			
	    			prefix=prefix+s.pop();;
	    		}
	    		s.pop();
	    	}
	    	else {
	    		while(!s.isEmpty()  && ( prec(c)<prec(s.peek()) || (prec(c)<=prec(s.peek())&& c=='^'))) {
	    			
	    			prefix=prefix+s.pop();
	    		}
	    		s.push(c);
	    	}
		}
		
		String revPrefix ="";
		for(int i=prefix.length()-1;i>=0;i--) {
			revPrefix=revPrefix+prefix.charAt(i);
		}
		return revPrefix;
	}
	
	public static int prec(char a) {
		if(a=='+' || a=='-') {
			return 1;
		}else if(a=='/'||a=='*') {
			return 2;
		}else if (a=='^') {
			return 3;
		}else {
			return -1;
		}
	}
}


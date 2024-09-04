import java.util.Scanner;
import java.util.Stack;

class PrefixToInfix {
	public static void main (String[] args) {
		PrefixToInfix g=new PrefixToInfix();
	       Scanner myObj = new Scanner(System.in);
		String prefix =myObj.nextLine();
	
		String infix = g.convert(prefix);
		System.out.println(infix);
	}
	public  String convert(String prefix){
	    
	    Stack<String> s= new Stack<String>();
	    int l = prefix.length();
	    for(int i=l-1;i>=0;i--){
	        char c= prefix.charAt(i);
	        
	        if(Character.isLetterOrDigit(c)){
	            s.push(c+"");
	        }else if(isOperator(c)){
	            String first = s.pop();
	            String second= s.pop();
	            String operation = "("+first+c+second+")";
	            s.push(operation);
	        }
	    }
	    return s.pop();
	}
	public  boolean isOperator(char c){
	    if(c=='+'|| c=='-' || c=='*' || c=='/'){
	        return true;
	    }
		return false;
	    
	}
}
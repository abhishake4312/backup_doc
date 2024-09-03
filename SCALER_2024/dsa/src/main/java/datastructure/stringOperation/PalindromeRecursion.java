package datastructure.stringOperation;

public class PalindromeRecursion {
	static boolean checkpalindrome(String s){
		
		return isPalindrome(s, 0 , s.length()-1);
	}
	static boolean isPalindrome(String s, int i, int j){
		if(i>=j){
			return true;
		}
		if(s.charAt(i)==s.charAt(j)){
			return isPalindrome(s,i+1,j-1);
		}else{
			return false;
		}
	}
	
	static boolean iterative(String s){
		int i=0;
		int j=s.length()-1;
		
		while(i<j){
			if(s.charAt(i)==s.charAt(j)){
				i++;
				j--;
			}else{
				return false;
			}
		}
		return true;
	}
        public static void main(String[] args){
        	String s="abzcba";
        	System.out.println("recursive check "+s+" result "+checkpalindrome(s));
          	System.out.println("iterative check "+s+" result "+iterative(s));
        }
}

package stringOperation;

import java.util.Arrays;

public class CompareToMethod {

	
	public static void main(String[] args){
		
		String s="abhi";
		String s2="abhish";
		
	//	s.charAt(0)='v';
		
		System.out.println(s.compareTo(s2));
	//	System.out.println(s.charAt(4));
		
		String s3="mnopsa";
		char[] c3=s3.toCharArray();
		Arrays.sort(c3);
		s3=new String(c3);
		System.out.println(s3);
		
		System.out.println(s3.equals(s2));
		
		String s4="ibah";
		System.out.println(s4.equals(s));
	}
}

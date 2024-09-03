package datastructure;

public class ModandInt {

	public static void main(String[] args){
		
		int mod = (int)(Math.pow(10, 9)+7);
		
		int a = (int)(Math.pow(10, 10));
		long b = 100;	
		long val =  (a*b);
		
		//Below is incorrect as val losses its long value when first converted to int
		int finalreturnval  = (int)val%mod ;  
		
		//Below is correct as we first take mod of entire long value then convert to int
		int finalreturnval2 = (int)(val%mod);
		
		
		System.out.println(finalreturnval);
		System.out.println(finalreturnval2);
		
		System.out.println(val);
	}
}

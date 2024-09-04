
public class Mod_Java {

	public static void main(String[] args){
		double x= (float)40/-7;
		
		int mod = -40%7;
		System.out.println(x);
		System.out.println(mod);
		
		int a = (int)(Math.pow(10,9));
		int b = (int)(Math.pow(10,9));
		int c = (int)Math.pow(10,9)+7;
		System.out.println(a);
		int d = (a*b)%c; // here to make product in range we do mod operation but a*b itself will overflow int value
		
		int e = (int)((long)a%c * b%c)%c;// even in this case the product will overflow so convert to long first
		
		System.out.println(d);
		System.out.println(e);
		
		
		String s = String.valueOf(a);
		System.out.println(s);
		
		long m = 2;
		int n= 3;
		
		long z= 222222222222L;
		int intconvert= (int)z;
		int intconvertaftermod= (int)(z%c);
		System.out.println("int convert"+intconvert);
		System.out.println("int convert after mod"+intconvertaftermod);
		
	//	int c = m%n;
	}
}

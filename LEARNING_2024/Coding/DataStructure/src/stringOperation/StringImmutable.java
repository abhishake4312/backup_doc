package stringOperation;

public class StringImmutable {

	public static void main(String[] args){
		
		String s="abhi";
		System.out.println(s.getBytes());
		s.concat("singh");
		System.out.println(s.getBytes());
		System.out.println(s);
		
		Integer a= 20;
		
		a=a+5;// Integer is also immutable and a new a object is created with a=25
		System.out.println(a);
	}
}

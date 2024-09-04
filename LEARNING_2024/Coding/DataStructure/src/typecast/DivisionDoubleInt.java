package typecast;

public class DivisionDoubleInt {
	public static void main(String[] args){
		
		double a= 5/2; // as 5 and 2 both are integer the division happen in integer and value is 2.0
		int b =5/2;
		double c= (double)5/2;// 5 is typecasted to double and then divsion happened
		double d = 5*1.0/2;
		System.out.println("a "+a+" b "+b+" c "+c+ " d "+d);
		
	}
}


public class OverFlowIntLong {

	public static void main(String[] args){
	
	  int a = 2*1000000000;
	  int b= 2*1000000000;
	  
	  long c = (long)(a+b); // this is still wrong as addition is happening in int only so overflow
	  long d = (long)a+b;  // convert any variable to long first then add
	  System.out.println(c);
	  System.out.println(d);
	}
}

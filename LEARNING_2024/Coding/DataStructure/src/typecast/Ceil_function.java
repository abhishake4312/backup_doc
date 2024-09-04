package typecast;

public class Ceil_function {
public static void main(String[] args){
	int a =10;
	int b=6;
	int c=3;
	int z= a/(b-c);
	System.out.println(z);
	int z1= (int) Math.ceil(a/(b-c));
	System.out.println(z1);
	
	int z2= (int) Math.ceil((double)a/(b-c));
	System.out.println(z2);
	
}
}

package staticBlock;

public class MainMethodClass {

	
	static{
		System.out.println("Inside main class static block");
	}
	
	public static void main(String[] args){
		
		//as soon as StaticBlockMethod is loaded in JVM static block is executed
		StaticBlockMethod sb1=new StaticBlockMethod();
		System.out.println("Inside main class main method");
		//static block is executed only once no matter how many instance we create for the class
		StaticBlockMethod sb2=new StaticBlockMethod();
		
	}
}

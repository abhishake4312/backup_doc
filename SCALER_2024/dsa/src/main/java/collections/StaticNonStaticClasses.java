package collections;

public class StaticNonStaticClasses {
   
	int outervariable=10;
	static class NestedStaticClass{
		
		int normalInsideStatic=30;
		
		public  void nomralMethodInsideStatic(){
	//		outervariable=30;// The static nested class cannot access the non-static variable of outer class
			System.out.println("I am normal method inside static nested class");
		}
	}
	
	public void normalOuterclassMethod(){
		System.out.println("I am normal method of outer class");
	}
	
	class NestedNormalClass{
        int normalInsideNonStatic=30;
		
		public void nomralMethodInsideNonStatic(){
			outervariable=20;// non-static inner class can access variable of outer class.
			System.out.println("I am normal method inside static nested class");
		}
	}
	public static void main(String[] args){
		NestedStaticClass staticobj=new NestedStaticClass();
		staticobj.nomralMethodInsideStatic();
		
		//cannot create object of normal inner class directly need to create object of outer class
	//	NestedNormalClass normalobj=new NestedNormalClass();
		StaticNonStaticClasses s=new StaticNonStaticClasses();
		NestedNormalClass normalobj= s.new NestedNormalClass();
//		normalobj.normalOuterclassMethod();
	}
}

package interview.epam;
public class ExecutionOrder {
   public ExecutionOrder() {
      System.out.println("Entered in constructor");
   }
   public static void main(String[] args) {
      System.out.println("Entered in Main");
      ExecutionOrder e = new ExecutionOrder();
   }
   static int a = abc();
   static {
      System.out.println("Entered In static block");
   }  
   static int b = abc();
   
   public static int abc() {
      System.out.println("Entered in abc method");
      return 10;
   }
}



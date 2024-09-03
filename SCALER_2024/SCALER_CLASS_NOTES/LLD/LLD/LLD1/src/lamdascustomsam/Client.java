package lamdascustomsam;

public class Client {
    public static void main(String[] args) {
        Adder adder = new Adder();
        int result=executeOperation(5,10,adder);
        System.out.println(result);

        int result2=executeOperation(10,5,(a,b)->a-b);
        System.out.println(result2);

       
    }
    public static int executeOperation(int a, int b,  CalculatorSAM calculator) {
        return calculator.calculateOperation(a,b);
    }
}

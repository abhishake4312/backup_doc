package lamdascustomsam;

public class Adder implements CalculatorSAM{
    @Override
    public int calculateOperation(int a, int b) {
        return a + b;
    }
}

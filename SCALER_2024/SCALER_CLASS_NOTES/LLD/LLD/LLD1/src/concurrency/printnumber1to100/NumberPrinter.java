package concurrency.printnumber1to100;

public class NumberPrinter implements Runnable{
    private int num;

    public NumberPrinter(int n) {
        num = n;
    }

    @Override
    public void run() {
        System.out.println("Number printed is "+num+" inside thread "+Thread.currentThread().getName());
    }
}

package concurrency.helloworldthread;

public class HelloWorldPrinter implements Runnable{


    @Override
    public void run() {
        System.out.println("Printing Hello world inside "+Thread.currentThread().getName());
    }
}

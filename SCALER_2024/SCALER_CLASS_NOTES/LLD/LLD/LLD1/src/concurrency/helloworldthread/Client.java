package concurrency.helloworldthread;

public class Client {
    public static void main(String[] args) {
        HelloWorldPrinter p=new HelloWorldPrinter();
        System.out.println("Inside main thread  "+Thread.currentThread().getName());
        Thread t=new Thread(p);
        t.start();
    }
}

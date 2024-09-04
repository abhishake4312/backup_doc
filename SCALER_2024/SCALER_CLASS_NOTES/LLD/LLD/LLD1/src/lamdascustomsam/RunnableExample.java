package lamdascustomsam;

public class RunnableExample {
    public static void main(String[] args) {
        int x=10;
        Runnable runnable=()->{
            System.out.println(x);
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }
}

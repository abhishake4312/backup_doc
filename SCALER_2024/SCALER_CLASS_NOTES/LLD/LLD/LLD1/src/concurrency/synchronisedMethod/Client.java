package concurrency.synchronisedMethod;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        Count obj = new Count();
        Thread adder= new Thread(new Runnable(){
            public void run(){
                for(int i=1; i<10000; i++){
                    obj.changeValue(i);
                }
            }
        });

        Thread sub=new Thread(new Runnable(){
            public void run(){
                for(int i=1; i<10000; i++){
                    obj.changeValue(-i);
                }
            }
        });
        adder.start();
        sub.start();
        adder.join();
        sub.join();
        System.out.println(obj.getValue());
    }
}

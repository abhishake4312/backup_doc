package concurrency.executorIntro;

public class Client {

    public static void main(String[] args) {

        for(int i=1;i<100;i++){
            PrintNumberOnThread p=new PrintNumberOnThread(i);
            Thread t=new Thread(p);
            t.start();
        }

    }
}

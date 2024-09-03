package concurrency.executorIntro;

public class PrintNumberOnThread implements Runnable{
    int num;
    public PrintNumberOnThread(int num) {
        this.num = num;
    }
    @Override
    public void run() {
        System.out.println("PrintNumberInNewThread "+num+" "+Thread.currentThread().getName());
    }
}

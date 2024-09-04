package concurrency.executorIntro;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFramework {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i=1;i<100;i++){
            if(i==5 || i==12 || i==15){
                System.out.println(i);
            }
            PrintNumberOnThread pnt = new PrintNumberOnThread(i);

            executor.execute(pnt);
        }
        executor.shutdown();
    }
}

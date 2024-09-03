package concurrency.PCsemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    Queue<Object> queue;
    int maxSize;
    Semaphore consumerSemaphore;
    Semaphore producerSemaphore;

    public Consumer(int maxSize, Queue<Object> queue,Semaphore producerSemaphore,Semaphore consumerSemaphore) {
        this.maxSize = maxSize;
        this.queue = queue;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }


    @Override
    public void run() {
        while(true){
            try {
                consumerSemaphore.acquire();
         //       if(queue.size()>0) {
                    System.out.println("Consumer " + Thread.currentThread().getName());
                    queue.remove();
           //     }
                producerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package concurrency.PCsemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements   Runnable{

    Queue<Object> queue;
    int maxSize;
    Semaphore consumerSemaphore;
    Semaphore producerSemaphore;
    public Producer(int maxSize, Queue<Object> queue,Semaphore producerSemaphore,Semaphore consumerSemaphore) {
        this.maxSize = maxSize;
        this.queue = queue;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }


    @Override
    public void run() {
        while(true){

            try {
                producerSemaphore.acquire();
       //         if(queue.size()<maxSize) {
                    System.out.println("Producer " + Thread.currentThread().getName());
                    queue.add(new Object());
       //         }
                consumerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

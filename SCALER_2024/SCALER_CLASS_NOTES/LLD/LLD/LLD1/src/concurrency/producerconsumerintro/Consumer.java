package concurrency.producerconsumerintro;

import java.util.Queue;

public class Consumer implements Runnable{

    Queue<Object> queue;
    int maxSize;
    public Consumer(int maxSize, Queue<Object> queue) {
        this.maxSize = maxSize;
        this.queue = queue;
    }


    @Override
    public void run() {
        while(true){
            synchronized("queue1") {
                if (queue.size() > 0) {
                    System.out.println("Consumer "+Thread.currentThread().getName());
                    queue.remove();
                }
            }
        }
    }
}

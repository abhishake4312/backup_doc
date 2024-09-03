package concurrency.producerconsumerintro;

import java.util.Queue;

public class Producer implements   Runnable{

    Queue<Object> queue;
    int maxSize;
    public Producer(int maxSize, Queue<Object> queue) {
        this.maxSize = maxSize;
        this.queue = queue;
    }


    @Override
    public void run() {
        while(true){
            synchronized("queue2") {
            if(queue.size()<maxSize){
                System.out.println("Producer "+Thread.currentThread().getName());
                    queue.add(new Object());
                }
            }
        }
    }
}

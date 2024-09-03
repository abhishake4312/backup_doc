package concurrency.PCsemaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {

    public static void main(String[] args) {
        Queue<Object> queue = new ConcurrentLinkedQueue<>();
        int maxsize=6;
        Semaphore producerSemaphore = new Semaphore(6);
        Semaphore consumerSemaphore = new Semaphore(0);

        Producer p1=new Producer(maxsize,queue,producerSemaphore,consumerSemaphore);
        Producer p2=new Producer(maxsize,queue,producerSemaphore,consumerSemaphore);
        Producer p3=new Producer(maxsize,queue, producerSemaphore,consumerSemaphore);

        Thread pt1=new Thread(p1);
        Thread pt2=new Thread(p2);
        Thread pt3=new Thread(p3);

        Consumer c1=new Consumer(maxsize,queue, producerSemaphore,consumerSemaphore);
        Consumer c2=new Consumer(maxsize,queue, producerSemaphore,consumerSemaphore);
        Consumer c3=new Consumer(maxsize,queue, producerSemaphore,consumerSemaphore);

        Thread ct1=new Thread(c1);
        Thread ct2=new Thread(c2);
        Thread ct3=new Thread(c3);

        pt1.start();
        pt2.start();
        pt3.start();

        ct1.start();
        ct2.start();
        ct3.start();

    }
}

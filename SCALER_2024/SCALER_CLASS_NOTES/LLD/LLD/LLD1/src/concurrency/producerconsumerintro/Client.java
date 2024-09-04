package concurrency.producerconsumerintro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Client {

    public static void main(String[] args) {
        Queue<Object> queue = new ConcurrentLinkedQueue<Object>();
        int maxsize=6;
        Producer p1=new Producer(maxsize,queue);
        Producer p2=new Producer(maxsize,queue);
        Producer p3=new Producer(maxsize,queue);
        Thread pt1=new Thread(p1);
        Thread pt2=new Thread(p2);
        Thread pt3=new Thread(p3);

        Consumer c1=new Consumer(maxsize,queue);
        Consumer c2=new Consumer(maxsize,queue);
        Consumer c3=new Consumer(maxsize,queue);
        Thread ct4=new Thread(c1);
        Thread ct5=new Thread(c2);
        Thread ct6=new Thread(c3);

        pt1.start();
        pt2.start();
        pt3.start();

        ct4.start();
        ct5.start();
        ct6.start();

    }
}

package concurrency.threadintro;

import java.util.List;

public class Client {
    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//        Thread t1 = new Thread(myThread1);
//        Thread t2 = new Thread(myThread2);
//        t1.start();
//        t2.start();

        ContestExample contestExample = new ContestExample();
        ContestExample contestExample1 = new ContestExample();
        contestExample.start();
        contestExample1.start();

        int sum=0;
            List<Integer> numbers = List.of(1,2,3,4);
       //     numbers.forEach(n->sum+=n){
            System.out.println(sum);
        }
    }

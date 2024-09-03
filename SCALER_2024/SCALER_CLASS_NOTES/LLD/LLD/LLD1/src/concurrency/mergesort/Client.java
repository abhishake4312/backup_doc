package concurrency.mergesort;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception{
        List<Integer> list = List.of(5,4,7,2,1,6,3,8);
      //  ExecutorService executorService= Executors.newSingleThreadExecutor();
       ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter sorter=new Sorter(list,executorService);
        Future<List<Integer>> future=executorService.submit(sorter);

        List<Integer> sortedArray=future.get();
        System.out.println(sortedArray);

    }
}

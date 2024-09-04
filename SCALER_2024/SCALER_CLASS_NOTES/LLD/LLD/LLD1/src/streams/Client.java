package streams;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
       example7();
    }
    public static void example1(){
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);

        Stream<Integer> stream= list.stream();
        stream.forEach((ele)->{
            System.out.println(ele);
        });
    }
    public static void example3(){
        List<Integer> list = List.of(1,2,3,4,5);
        Stream<Integer> stream= list.stream();
        stream.
                map((element)->{
                    System.out.println(element*element);
            return element*element;
        })
                .forEach((element)->{
            System.out.println(element);
        });
    }
    public static void example4() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        stream.filter((element)-> element%2==0)
                .map((element)->element*element)
                .forEach((element)->{
                    System.out.println(element);
                });
        //original list remains same
        System.out.println(list);
    }

    public static void example5() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
       int finalsum= stream.reduce(0,(sum,element)->{
            return sum+element;
        });
        System.out.println(finalsum);
    }

    public static void example6() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.parallelStream();
        stream.forEach((element)->{
            System.out.println("printing element on different thread  element"+Thread.currentThread().getName());
        });
    }
    public static void example7(){
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        List<Integer> streamAsList=stream
                                          .filter((ele)->ele%2==0)
                                          .map((element)->element)
                                          .collect(Collectors.toList());
        System.out.println(streamAsList);
    }
}

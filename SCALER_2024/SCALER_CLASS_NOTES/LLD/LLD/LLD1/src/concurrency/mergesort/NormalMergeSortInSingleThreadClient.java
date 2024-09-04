package concurrency.mergesort;

import java.util.List;

public class NormalMergeSortInSingleThreadClient {

    public static void main(String[] args) {
        List<Integer> list = List.of(2,3,4,1,5,6,7,8);

        NormalMergeSortInSingleThreadSorter sort = new NormalMergeSortInSingleThreadSorter();
        List<Integer> sorted=sort.sorter(list);
        for(int i=0;i<sorted.size();i++){
            System.out.print(sorted.get(i)+" ");
        }
    }
}

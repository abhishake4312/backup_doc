package concurrency.mergesort;

import java.util.ArrayList;
import java.util.List;

public class NormalMergeSortInSingleThreadSorter {

     List<Integer> sorter(List<Integer> list){

         if(list.size() == 1){
             return list;
         }
         int mid=list.size()/2;
         List<Integer> left = new ArrayList<Integer>(list.subList(0, mid));
         List<Integer> right = list.subList(mid, list.size());

         List<Integer> leftSortedArray = sorter(left);
         List<Integer> rightSorterArray = sorter(right);


         int i = 0;
         int j = 0;
         List<Integer> sortedArray = new ArrayList<>();


         while(i < leftSortedArray.size() && j < rightSorterArray.size()) {
             if(leftSortedArray.get(i) < rightSorterArray.get(j)) {
                 sortedArray.add(leftSortedArray.get(i));
                 i++;
             } else {
                 sortedArray.add(rightSorterArray.get(j));
                 j++;
             }
         }

         while(i < leftSortedArray.size()) {
             sortedArray.add(leftSortedArray.get(i));
             i++;
         }

         while(j < rightSorterArray.size()) {
             sortedArray.add(rightSorterArray.get(j));
             j++;
         }

         return sortedArray;
     }
}

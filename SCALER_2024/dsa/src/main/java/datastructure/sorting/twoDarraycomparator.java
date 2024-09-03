package datastructure.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class twoDarraycomparator {
    public static void main(String[] args) {
        Integer[][] arr= {{2,3,4},{5,6,7},{1,9,10},{4,8,9}};
        Arrays.sort(arr,new Comparator<Integer[]>() {
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0]-o2[0];
            }
        });
        System.out.println(Arrays.deepToString(arr));

    }
}

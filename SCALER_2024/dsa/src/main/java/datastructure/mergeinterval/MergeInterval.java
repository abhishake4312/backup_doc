package datastructure.mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval {
    public static int[][] mergeInterval(int[][] intervals){
        int n = intervals.length;
        int m= intervals[0].length;
        Integer[][] arr=new Integer[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=intervals[i][j];
            }
        }
        Arrays.sort(arr,new Comparator<Integer[]>() {
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0]-o2[0];
            }
        });
        System.out.println(Arrays.deepToString(arr));
        ArrayList<Integer[]> al = new ArrayList<Integer[]>();
        Integer[] prev = arr[0];
        for (int i = 1; i < n; i++) {
            int sfirst = prev[0];
            int efirst = prev[1];
            int ssecond = intervals[i][0];
            int esecond = intervals[i][1];
            if (ssecond <= efirst) {
                // Integer[] newArr=new Integer[2];
                prev[0] = sfirst;
                prev[1] = Math.max(efirst, esecond);

            } else {
                al.add(prev);
                prev = arr[i];
            }
        }
        al.add(prev);
        int[][] ret = new int[al.size()][2];
        for (int i = 0; i < al.size(); i++) {
            for(int j=0;j<m;j++){
                ret[i][j]=al.get(i)[j];
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        int[][] intervals={{1,4},{0,1}};
        int[][] ret= mergeInterval(intervals);
        System.out.println(Arrays.deepToString(ret));
    }
}

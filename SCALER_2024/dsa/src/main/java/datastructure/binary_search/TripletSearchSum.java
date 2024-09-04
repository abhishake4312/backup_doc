package datastructure.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class TripletSearchSum {
	 public static void solve(int[] A ) {
	        Arrays.sort(A);
	        int n=A.length;
	        ArrayList<Integer> al = new ArrayList<Integer>();
	        int p=1;
	        int sumret=0;
	        for(int i=0;i<=n-3;i++){
	            for(int j=i+1;j<=n-2;j++){
	                for(int k=j+1;k<=n-1;k++){
	                  int sum= A[i]+A[j]+A[k];
	                  al.add(sum);
	                  
	                }
	            }
	        }
System.out.println();
	        for(int i=0;i<al.size();i++){
	        	System.out.print(al.get(i)+" ");
	        }
	    //    return al.get(B-1);
	    }
  public static void main(String[] args){
	  int[] arr= {4,2,8,5,7};
	solve(arr);
	//  System.out.println(solve(arr,183));
  }
}

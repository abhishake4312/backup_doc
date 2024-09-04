package datastructure.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Max_minHeap {
	
	static int[] finalarray(int[] A){
	 int n=A.length;
     ArrayList<Integer> al = new ArrayList<Integer>();
     for(int i=0;i<n;i++){
         al.add(A[i]);
     }
     PriorityQueue<Integer> min=new PriorityQueue<Integer>();
     PriorityQueue<Integer> max=new PriorityQueue<Integer>(Collections.reverseOrder());
     for(int i=0;i<n;i++){
         min.add(A[i]);
         max.add(A[i]);
     }
     for(int i=0;i<n;i++){
        
         int low=min.remove();
         int high=max.remove();
//         System.out.println("low"+low);
//         System.out.println("high"+high);
         int avg=(low+high)/2;
         for(int j=0;j<n;j++){
             if(A[j]==low){
                 A[j]=low+avg;
                 break;
             }
             
         }
         for(int j=0;j<n;j++){
        	 if(A[i]==high){
        		 A[i]=high-avg;
        		 break;
        	 }
         }
         min.clear();
         max.clear();
         for(int j=0;j<n;j++){
        	// System.out.println(A[j]);
             min.add(A[j]);
             max.add(A[j]);
         }
     }
     return A;
}
	public static void main(String[] args){
		int[] arr={2,2};
		int[] ret=finalarray(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(ret[i]);
		}
		
	}
}

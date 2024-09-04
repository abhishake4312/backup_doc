package datastructure.TwoPointer_Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class DifferentK {
	   public static int solve(int[] A, int B) {
	        int n=A.length;
	        HashSet<Integer> hs= new HashSet<Integer> ();
	        for(int i=0;i<n;i++){
	            hs.add(A[i]);
	        }
	    	Iterator itr = hs.iterator();
	    	System.out.println("Elements in hasheset");
			while(itr.hasNext()){
				System.out.print(itr.next());
			}
			 System.out.println();
	        int count=0;
	        for(int i=0;i<n;i++){
	            int search1=A[i]+B;
	            int search2= A[i]-B;
	            if(hs.contains(search1)){
	                count++;
	            }
	            if(hs.contains(search2)){
	                count++;
	            }
	            hs.remove(A[i]);
	        }
	        return count;
	    }
	   public static void main(String[] args){
		   int[] arr={8,5,1,10,5,9,9,3,5,6,6,2,8,2,2,6,3,8,7,2,5,3,4,3,3,2,7,9,6,8,7,2,9,10,3,8,10,6,5,4,2,3};
		   System.out.println();
		   System.out.println(solve(arr,3));
	   }
}

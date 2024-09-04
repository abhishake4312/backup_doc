package binary_search;

import java.util.Arrays;

public class CountTripletLessThanK {
	static int countTripletLessThan(int[] A,int B){
		 
		Arrays.sort(A);
		
		
		int n=A.length;
		int count=0;
		
		for(int i=0;i<=n-2;i++){
			int j=i+1;
		    int k=n-1;
		while(j<k){
			if(A[j]+A[k]<B-A[i]){
				count+=k-j;
				j++;
			}else{
				k--;
			}
			
		 }
		}
		return count;
	}
	static int countPairGreaterThanK(int[] A,int B){
		 
       Arrays.sort(A);
		
		
		int n=A.length;
		int count=0;
		
		for(int i=0;i<=n-2;i++){
			int j=i+1;
		    int k=n-1;
		while(j<k){
			if(A[j]+A[k]>k-A[i]){
				count+=k-j;
				k--;
			}else{
				j++;
			}
			
		 }
		}
		return count;
	}
	public static void main(String[] args){
		int[] A={5,3,7,8,3,5};
		int k=10;
		System.out.println("Count in Pair less than k "+countTripletLessThan(A,k));
		System.out.println("Count in Pair greater than k "+countPairGreaterThanK(A,k));
	}

}

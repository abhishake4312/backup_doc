package datastructure.binary_search;

import java.util.Arrays;

public class CountPairLessThanK {
	
	static int countPair(int[] A,int k){
		 
		Arrays.sort(A);
		
		int i=0;
		int j=A.length-1;
		int count=0;
		
		while(i<j){
			if(A[i]+A[j]<k){
				count+=j-i;
				i++;
			}else{
				j--;
			}
			
		}
		return count;
	}
	static int countPairGreaterThanK(int[] A,int k){
		 
		Arrays.sort(A);
		
		int i=0;
		int j=A.length-1;
		int count=0;
		
		while(i<j){
			if(A[i]+A[j]>=k){
				count+=j-i;
				j--;
			}else{
				i++;
			}
			
		}
		return count;
	}
	public static void main(String[] args){
		int[] A={5,3,7,8,3,5};
		int k=10;
		System.out.println("Count in Pair less than k "+countPair(A,k));
		System.out.println("Count in Pair greater than k "+countPairGreaterThanK(A,k));
	}

}

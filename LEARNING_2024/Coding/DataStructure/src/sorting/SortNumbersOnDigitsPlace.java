package sorting;

import java.util.Arrays;
import java.util.Comparator;


// Problem: Array is given we need to sort this array based on digits bit given as k
// TC: O(nlog(n))  SC=O(1)
public class SortNumbersOnDigitsPlace {
	static void sortBasedOnDigits(Integer[] arr,final int k){
		
		Arrays.sort(arr,new Comparator<Integer>(){
			public int compare(Integer a,Integer b){
				int valA= ((int)(a/Math.pow(10, k)))%10;
				int valB=  ((int)(b/Math.pow(10, k)))%10;
				return valA-valB;
			}
		});
	}
	
	public static void main(String[] args){
		
		Integer[] arr= { 42,45,320,23,65,889};
		int k=1;
		
		sortBasedOnDigits(arr,k);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}

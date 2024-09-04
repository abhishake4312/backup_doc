package sorting;

import java.util.ArrayList;

public class BucketSortNumberBasedOnDigitPlace {
	
	public static void bucketSort(int[] arr, int k){
		// TC=(O(n+n+d)  d=range of digits 
		// SC= O(n+d) -- number of arrayList created and total sum of all arrayList  is n.
		ArrayList<Integer>[] bucket=new ArrayList[10];
		int n=arr.length;
		for(int i=0;i<n;i++){
			int index= ((int)(arr[i]/Math.pow(10, k))%10);
			if(bucket[index]==null){
				bucket[index]=new ArrayList<Integer>();
			}
			bucket[index].add(arr[i]);
		}
		int p=0;
		for(int i=0;i<10;i++){
			ArrayList<Integer> al=bucket[i];
			if(al!=null){
				for(int j=0;j<al.size();j++){
					arr[p]=al.get(j);
					p++;
				}
			}
		}
	}

	public static void main(String[] args){
		
		int[] arr= { 742,45,320,23,65,889};
		int k=1;
		
		bucketSort(arr,k);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}

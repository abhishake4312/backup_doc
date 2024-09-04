package datastructure.sorting;

public class QuickSort {
	
	public static void quicksort(int[] arr,int s,int e){
		if(s<e){
			int partitionIndex=partioning(arr,s,e);
			quicksort(arr,s,partitionIndex-1);
			quicksort(arr,partitionIndex+1,e);
		}
	}
	
	static int partioning(int[] arr, int s ,int e){
		int pivot= arr[e];
		
		int i=s;
		for(int j=s;j<=e-1;j++){
			if(arr[j]<=pivot){
				int tmp=arr[j];
				arr[j]=arr[i];
				arr[i]=tmp;
				i++;
			}
		}
		int tmp=arr[i];
		arr[i]=arr[e];
		arr[e]=tmp;
		return i;
	}

	public static void main(String[] args){
		
	//	int[] arr= { 5,3,2,7,8,1};
		int[] arr={2,4,5,7,5,4,9,10,1,0,5,4,22,1,4,3};
		System.out.println("Before");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
		System.out.println();
		quicksort(arr,0,arr.length-1);
		System.out.println("After");
		for(int i=0;i<arr.length;i++){
			System.out.print(+arr[i]+" ");
		}
	}
}

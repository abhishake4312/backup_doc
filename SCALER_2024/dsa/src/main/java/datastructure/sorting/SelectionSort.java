package datastructure.sorting;

public class SelectionSort {

	void selectionSort(int[] arr){
		
		for(int i=0;i<arr.length-1;i++){
			int min=arr[i];
			int minPos=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<min){
					min=arr[j];
					minPos=j;
				}
			}
			int tmp=arr[i];
			arr[i]=arr[minPos];
			arr[minPos]=tmp;
		}
	}
	public static void main(String args[]){
		SelectionSort bs= new SelectionSort();
		int[] arr={5,4,3,2,1};
		bs.selectionSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}

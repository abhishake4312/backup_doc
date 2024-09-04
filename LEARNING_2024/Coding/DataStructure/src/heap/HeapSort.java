package heap;

import java.util.ArrayList;

public class HeapSort {
    
	static void sort(int[] arr){
		buildMinHeap(arr);
		int size=arr.length;
		while(size>0){
			extractMin(arr,size);
			size--;
		}
	}
	static void buildMinHeap(int[] arr){
		int n=arr.length;
		
		for(int i= (n-2)/2;i>=0;i--){
			heapify(arr,i,n);
		}
	}
	static void heapify(int[] arr,int index,int size){
		int pindex=index;
		int leftcindex=2*pindex+1;
		int rightcindex=2*pindex+2;
		int n=size;
		
		while((2*pindex+1)<n){
		    leftcindex=2*pindex+1;
		    rightcindex=2*pindex+2;
		    int rightcval= (rightcindex<n)?arr[rightcindex]:Integer.MAX_VALUE;
			int minval= Math.min(arr[pindex], Math.min(arr[leftcindex],rightcval));
			if(minval==arr[pindex]){
				break;
			}else if(minval==arr[leftcindex]){
				int tmp=arr[pindex];
				arr[pindex]=arr[leftcindex];
				arr[leftcindex]=tmp;
				pindex=leftcindex;
			}else if(rightcindex<n && minval==arr[rightcindex]){
				int tmp=arr[pindex];
				arr[pindex]=arr[rightcindex];
				arr[rightcindex]=tmp;
				pindex=rightcindex;
			}	
		}
	}

	static void extractMin(int[] arr,int size){
		int last=size-1;
		int first=0;
		int tmp=arr[first];
		arr[first]=arr[last];
		arr[last]=tmp;
	
		heapify(arr,0,size-1);
	
	}
	public static void main(String[] args){
		int[] arr={3,12,10,15,8,12,13,10,6,5,11};
		
		sort(arr);
		
		System.out.println("After sorting the array using heap");
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
}

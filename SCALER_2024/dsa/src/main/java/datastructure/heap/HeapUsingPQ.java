//package datastructure.heap;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.PriorityQueue;
//
//public class HeapUsingPQ {
//
//	//This is O(nlogn) as inserting one by one
//	static void createHeapPQ(int[] arr){
//
//		ArrayList<Integer> al = new ArrayList<Integer>();
//
//		for(int i=0;i<arr.length;i++){
//			al.add(arr[i]);
//		}
//		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(al);
//
//
//
//		for(int i=0;i<arr.length;i++){
//			heap.add(arr[i]);
//		}
//	}
//
//	static void createHeapManual(int[] arr){
//			int n=arr.length;
//
//			for(int i= (n-2)/2;i>=0;i--){
//				heapify(arr,i);
//			}
//		}
//
//
//	  public static void main(String[] args){
//		  int[] arr={5,6,7,3,6,2};
//		  createHeapPQ(arr);
//		  createHeapManual(arr);
//	  }
//
//  static void heapify(int[] arr,int index){
//		int pindex=index;
//		int leftcindex=2*pindex+1;
//		int rightcindex=2*pindex+2;
//		int n=arr.length;
//
//		while((2*pindex+1)<n){
//		    leftcindex=2*pindex+1;
//		    rightcindex=2*pindex+2;
//		    int rightcval= (rightcindex<n)?arr[rightcindex]:Integer.MAX_VALUE;
//			int minval= Math.min(arr[pindex], Math.min(arr[leftcindex],rightcval));
//			if(minval==al.get(pindex)){
//				break;
//			}else if(minval==al.get(leftcindex)){
//				int tmp=al.get(pindex);
//				al.set(pindex, al.get(leftcindex));
//				al.set(leftcindex, tmp);
//				pindex=leftcindex;
//			}else if(rightcindex<n && minval==al.get(rightcindex)){
//				int tmp=al.get(pindex);
//				al.set(pindex,al.get(rightcindex));
//				al.set(rightcindex,tmp);
//				pindex=rightcindex;
//			}
//		}
//	}
//}

package datastructure.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindingMinAndMaxEachTime {
	
	static void findingMINMAX(int[] arr){
		int n=arr.length;
		for(int i=0;i<n;i++){
			Arrays.sort(arr);
			int a=arr[0];
			int b=arr[n-1];
			int avg=(a+b)/2;
			arr[0]=arr[0]+avg;
			arr[n-1]=arr[n-1]-avg;
			
		}
	}
	static int[] usingHeap(int[] arr){
		int n=arr.length;

		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++){
			al.add(arr[i]);
		}
		PriorityQueue<Integer> min=new PriorityQueue<Integer>(al);
		PriorityQueue<Integer> max=new PriorityQueue<Integer>(Collections.reverseOrder());
		max.addAll(al);
		for(int i=0;i<n;i++){
			int x=min.remove();
			int y=max.remove();
			int avg=(x+y)/2;
			x=x+avg;
			y=y-avg;
			min.add(x);
			min.add(y);
			max.add(x);
			max.add(y);
		}
		int[] ret=new int[n];
		for(int i=0;i<n-1;i++){
			ret[i]=min.remove();
		}
		ret[n-1]=max.remove();
		return ret;
		
	}

	public static void main(String[] args){
		int[] arr= {6,23,53,21,444};
		
		findingMINMAX(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		int[] arr2= {6,23,53,21,444};
		System.out.println("Using heap");
		int[] ret=usingHeap(arr2);
		for(int i=0;i<ret.length;i++){
			System.out.print(ret[i]+" ");
		}
	}
}

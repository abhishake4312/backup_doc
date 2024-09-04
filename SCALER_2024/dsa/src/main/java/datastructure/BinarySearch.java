package datastructure;

import java.util.ArrayList;
import java.util.List;


public class BinarySearch {
	
	public static boolean binarySearch(int[] arr,int s , int e,int key){
		
		if(s<=e){
			int mid = (s+e)/2;
			
			if(arr[mid]==key){
				return true;
			}
			else if(key<arr[mid]){
			binarySearch(arr,s,mid-1,key);
			}else{
			binarySearch(arr,mid+1,e,key);
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		
		
		List<ArrayList<Integer>> al= new ArrayList<ArrayList<Integer>>();
		int arr[] = {1,2,3,4,5};
		System.out.println(binarySearch(arr,0,4,7));
	}

}

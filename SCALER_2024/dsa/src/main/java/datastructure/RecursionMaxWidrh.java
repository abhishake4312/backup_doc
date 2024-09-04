package datastructure;

import java.util.Arrays;


public class RecursionMaxWidrh {
	
	static int maxWidth(int arr[], int s,int e){
//		if(s+1==e){
//			return arr[e]-arr[s];
//		}
		if(s>=e){
			return 0;
		}
		
	   int count=0;
		
		for(int i=s;i<=e;i++){
			int diff=arr[e]-arr[i];
			int elements=e-i+1-2;

			count=count+diff*(int)Math.pow(2, elements);
			System.out.println("inside"+count);
		}
	//	count=count+arr[e]-arr[e-1];
	
		for(int j=e-1;j>=s;j--){
			int diff=arr[j]-arr[s];
			int elements=j-s+1-2;

			count=count+diff*(int)Math.pow(2, elements);
			
		}
	//	count=count+arr[s+1]-arr[s];
		System.out.println(count);
		int c4=maxWidth(arr,s+1,e-1);
		return count+c4;
	}

	public static void main(String[] args){
		
		int arr[] = { 1,2,3,10,10};
		Arrays.sort(arr);
		int n=arr.length;
		System.out.println(maxWidth(arr,0,n-1));
	}
}

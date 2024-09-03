package datastructure;

import java.util.HashSet;


public class NiceSubArray012 {
	
	public static void main(String[] args){
		
		int[] arr={0,1,0,0,2,0,2,0,0,1,0};
		int n=arr.length;
		int count=0;
		
//		for(int i=0;i<=n-3;i++){
//			HashSet<Integer> hs = new HashSet<Integer>();
//			hs.add(arr[i]);
//			hs.add(arr[i+1]);
//			for(int j=i+2;j<n;j++){
//				hs.add(arr[j]);
//				if(hs.size()==3){
//					count++;
//				}
//			}
//			
//			
//		}
		int[] freq=new int[3];
		int l=0;
		int r=0;
		int required=3;
		for( r=0;r<n;r++){
			
			if(freq[arr[r]]==0){
				required--;
			}
			freq[arr[r]]=freq[arr[r]]+1;
			
			while(required==0){
				count+=n-r;
				freq[arr[l]]=freq[arr[l]]-1;
				
				if(freq[arr[l]]==0){
					required++;
				}
				l++;
			}
			
			
			
		}
		System.out.println(count);
	}

}

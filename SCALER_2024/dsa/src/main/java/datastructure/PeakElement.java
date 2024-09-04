package datastructure;

import java.util.ArrayList;


public class PeakElement {
	
	static ArrayList<Integer>  peakelement(int[] A){
		
		int n=A.length;
		ArrayList<Integer> al =new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			if(i==0){
				if(A[i]>=A[i+1]){
					al.add(i);
				}
			}else if(i>0 && i<n-1){
				if(A[i]>=A[i-1] && A[i]>=A[i+1]){
					al.add(i);
				}
			}else if(i==n-1){
				if(A[i]>=A[i-1]){
					al.add(i);
				}
			}
		}
		return al;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,1,1,2,1,1,1};
		ArrayList<Integer> ret=peakelement(arr);
		for(int i=0;i<ret.size();i++){
			System.out.println(ret.get(i));
		}

	}

}

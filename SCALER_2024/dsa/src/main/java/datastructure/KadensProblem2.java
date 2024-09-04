package datastructure;

import java.util.ArrayList;


public class KadensProblem2 {

	static ArrayList<Integer> findMaxSumIndex(int[] arr){
		
		int left=-1;
		int right=-1;
		int sum=0;
		int maxSum=Integer.MIN_VALUE;
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(left);
		al.add(right);
		for(int i=0;i<arr.length;i++){
			sum=sum+arr[i];
			if(sum>maxSum){
				al.set(0,left+1);
				al.set(1,right+1);
				maxSum=sum;
			}
			if(sum<0){
				left=i;
				right=i;
				sum=0;
			}else{
				right++;
			}
		}
		return al;
		
	}
	
	public static void main(String[] args){
	//	int[] a={10,-5,7,8,-11,2,-20,10,-3,-10,15,8,-10};
		int[] a={-20,4,-5,2,5};
		
		ArrayList<Integer> ret=findMaxSumIndex(a);
		System.out.println(ret.get(0)+" "+ret.get(1));
	}
}

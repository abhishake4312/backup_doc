package datastructure.binary_search;

public class LessThanEqualTo {
   static int[] lessthanequal(int[] B,int[] sorted){
	   int n=B.length;
	   int m=sorted.length;
	   int[] ret=new int[n];
	   for(int i=0;i<n;i++){
		   ret[i]=bs(B[i],sorted,0,m-1);
	   }
	   return ret;
   }
   static int bs(int x,int[] A,int s ,int e){
	   
	   while(s<=e){
		   int mid=(s+e)/2;
		   if(x==A[mid]){
			   return x;
		   }
		   if(x<A[mid]){
			   e=mid-1;
		   }else{
			   s=mid+1;
		   }
	   }
	   if(e==-1){
		   return -1;
	   }
	   return A[e];
   }
	public static void main(String[] args){
		int[] B={5,9,5,15,7};
		int[] sorted={9,17,17,25,27,32,40,46,49};
		int[] ret=lessthanequal(B,sorted);
		for(int i=0;i<B.length;i++){
			System.out.println(ret[i]);
		}
	}
}

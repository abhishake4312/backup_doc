package binary_search;

import java.util.Arrays;

public class TripleSearchSum {
	 public static int solve(int[] A, int B) {
	        Arrays.sort(A);
	        int s=3;
	        int n=A.length;
	        int e=A[n-1]+A[n-2]+A[n-3];
	        int ans=0;
	        while(s<=e){
	            int mid=(s+e)/2;
	            System.out.println(mid);

	            int countLessthanmid=count(A,mid);
	            System.out.println("countLess "+countLessthanmid);
	           if(countLessthanmid==B){
	        	   ans=mid;
	        	   e=mid-1;
	           }
	            if(countLessthanmid<B){
	                s=mid+1;
	            }else if(countLessthanmid>B){
	            	ans=mid;
	                e=mid-1;
	                
	            }
	        }
	        return ans;
	    }
	   static  int count(int[] A,int B){

	        int count=0;
	        for(int i=0;i<=A.length-2;i++){
	            int target=B-A[i];
	            int left= i+1;
	            int right=A.length-1;
	            while(left<right){
	                if((A[left]+A[right])<=target){
	                    count+=right-left;
	                    left++;
	                }else{
	                    right--;
	                }
	            }
	          
	        
	    }
	      return count;
	}
	    public static void main(String[] args){
	    	// int[] arr= {4,2,3,5,7};
	    	 int[] arr= {22,10,5,11,16,2,11,7,16,2,17,6,15,3,9,6};
	    		System.out.println(solve(arr,183));
	    		
	    }
}

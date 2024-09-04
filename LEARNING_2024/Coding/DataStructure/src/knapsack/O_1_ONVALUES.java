package knapsack;

import java.util.Arrays;

public class O_1_ONVALUES {

	    public static int solve(int[] A, int[] B, int C) {
	        int maxValue= 500*50;
	        int[] prev=new int[maxValue+1];
	        
	        Arrays.fill(prev,1000000000);
	        prev[0]=0;
	         int[] curr=new int[maxValue+1];
	        for(int i=1;i<=A.length;i++){
	            for(int j=0;j<=maxValue;j++){
	                    if(j==0){
	                        curr[j]=0;
	                    }
	                    int val1=1000000000;
	                    if(A[i-1]<=j){
	                         val1=B[i-1]+prev[j-A[i-1]];
	                    }
	                    int val2=prev[j];
	                    curr[j]=Math.min(val1,val2);
	            }
	            for(int j=0;j<=maxValue;j++){
	           //     System.out.println(curr[j]);
	                prev[j]=curr[j];
	            }
	        }
	        int ans=0;
	        for(int i=maxValue;i>=0;i--){
	            if(curr[i]<=C){
	                ans=i;
	                break;
	            }
	        }
	        return ans;
	    }
	
  public static void main(String[] args){
	  int[] A={6,10,12};
	  int[] B={10,20,30};
	  System.out.println(solve(A,B, 50));
   }
  }

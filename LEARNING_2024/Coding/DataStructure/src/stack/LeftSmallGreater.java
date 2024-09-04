package stack;

import java.util.Stack;

public class LeftSmallGreater {
	
	public static int solve(int[] A) {
	        int n=A.length;
	        int[] leftsmall= calculateLS(A);
	        System.out.println();
	        System.out.println("leftsmall");
	        for(int i=0;i<n;i++){
	        	System.out.print(leftsmall[i]+" ");
	        }
	        System.out.println();
	        int[] rightsmall= calculateRS(A);
	        System.out.println("rightsmall");
	        for(int i=0;i<n;i++){
	        	System.out.print(rightsmall[i]+" ");
	        }
	        System.out.println();
	        int[] leftgreater= calculateLG(A);
	        System.out.println("leftgreater");
	        for(int i=0;i<n;i++){
	        	System.out.print(leftgreater[i]+" ");
	        }
	        System.out.println();
	        int[] rightgreater= calculateRG(A);
	        System.out.println("rightgreater");
	        for(int i=0;i<n;i++){
	        	System.out.print(rightgreater[i]+" ");
	        }

	        long sum=0;
	        long sum2=0;
	        int mod= (int)(Math.pow(10,9)+7);
	        for(int i=0;i<n;i++){
	            long left= i- (leftgreater[i]+1) +1;
	            if(rightgreater[i]==-1){
	                rightgreater[i]=n;
	            }
	            long right = (rightgreater[i]-1)-i+1;
	            long times= left*right;
	            sum = (sum + (A[i]* times))%mod;

	        }
	        for(int i=0;i<n;i++){

	            long left= i- (leftsmall[i]+1) +1;
	            if(rightsmall[i]==-1){
	                rightsmall[i]=n;
	            }
	            long right = (rightsmall[i]-1)-i+1;
	             long times= left*right;
	            sum2 = (sum2 + (A[i]* times)%mod)%mod; 
	        }
	        int retsum = (int)((sum-sum2)%mod);
	        return retsum;

	    }
	 
	 static  int[] calculateLS(int[] A){
	        int n=A.length;
	        Stack<Integer> s=new Stack<Integer>();
	        int[] ret=new int[n];
	        for(int i=0;i<n;i++){

	            while(!s.isEmpty() && A[s.peek()]>=A[i]){
	                s.pop();
	            }
	            if(s.isEmpty()){
	                ret[i]=-1;
	            }else{
	                ret[i]=s.peek();
	            }
	            s.push(i);
	        }
	        return ret;
	    }
	    static   int[] calculateRS(int[] A){
	        int n=A.length;
	        Stack<Integer> s=new Stack<Integer>();
	        int[] ret=new int[n];
	        for(int i=n-1;i>=0;i--){

	            while(!s.isEmpty() && A[s.peek()]>=A[i]){
	                s.pop();
	            }
	            if(s.isEmpty()){
	                ret[i]=-1;
	            }else{
	                ret[i]=s.peek();
	            }
	            s.push(i);
	        }
	        return ret;
	    }
	       static   int[] calculateLG(int[] A){
	        int n=A.length;
	        Stack<Integer> s=new Stack<Integer>();
	        int[] ret=new int[n];
	        for(int i=0;i<n;i++){

	            while(!s.isEmpty() && A[s.peek()]<=A[i]){
	                s.pop();
	            }
	            if(s.isEmpty()){
	                ret[i]=-1;
	            }else{
	                ret[i]=s.peek();
	            }
	            s.push(i);
	        }
	        return ret;
	    }
	     static  int[] calculateRG(int[] A){
	        int n=A.length;
	        Stack<Integer> s=new Stack<Integer>();
	        int[] ret=new int[n];
	        for(int i=n-1;i>=0;i--){

	            while(!s.isEmpty() && A[s.peek()]<=A[i]){
	                s.pop();
	            }
	            if(s.isEmpty()){
	                ret[i]=-1;
	            }else{
	                ret[i]=s.peek();
	            }
	            s.push(i);
	        }
	        return ret;
	    }

		public static void main(String[] args){
			int[] A={2,4,2,3};
			for(int i=0;i<A.length;i++){
				System.out.print(A[i]);
			}
			System.out.println(solve(A));
		}
}

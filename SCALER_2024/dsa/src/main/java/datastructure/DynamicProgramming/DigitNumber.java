package datastructure.DynamicProgramming;

public class DigitNumber {
	
	    public static int solve(int A, int B) {
	    	 int[][] dp = new int[A+1][B+1];
	         for(int i=0;i<=A;i++){
	             for(int j=0;j<=B;j++){
	                 dp[i][j]=-1;
	             }
	         }
	          int mod= 1000000007;
	       
	         int sumtotal= ways(A,B,dp,mod);
	        
	         System.out.println("sumtotal "+sumtotal);
	         int sum=0;
	  
	            
	             sum= dp[A-1][B];
	             sum=Math.max(sum,0);
	     System.out.println("sum "+sum);
	         return (sumtotal-sum)%mod;
	    }
	   static int ways(int d,int t,int[][] dp,int mod){
		   if(d==1){
	            if(t>=0 && t<10){
	            	dp[d][t]=1;
	                return dp[d][t];
	            }else{
	       
	                return 0;
	            }
	        }
	        
	        if( t<0){
	      
		                return 0;
	        }
	       
	      
	        if(dp[d][t]!=-1){
	            return dp[d][t];
	        }
	        long sum=0;
	        for(int i=0;i<=9;i++){
	        	 d=d-1;
	        	 t=t-i;
	        	 if(d<=0 || t<0){
	        		 
	        	 }else{
	        		 int ways= ways(d,t,dp,mod);
	        		 sum = (sum+ways)%mod;
	        	 }
	       //     System.out.println("digit"+d+" target"+t+"sum"+sum);
//	             sum = (sum+ ways(d-1,t-i,dp,mod))%mod;
//	             int ways= ways(d-1,t-i,dp,mod);
//	             dp[d-1][t-i]
	          //   System.out.println("digit"+d+" target"+t+"sum"+sum);
	        }
	        dp[d][t]=(int)(sum%mod);
	        return dp[d][t];
	    }
	public static void main(String[] args){
		System.out.println(-3%4);
	//	System.out.println(solve(75,22));
	}

}

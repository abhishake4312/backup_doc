package math.gcd;

import java.util.HashSet;

public class ConsecutiveSum {
	  public static int solve(int A) {

	        long[] prefix=new long[A+1];
	        prefix[1]=1;
	        for(int i=2;i<=A;i++){
	             prefix[i]=prefix[i-1]+i;
	        }

	        long count=0;
	        for(int i=1;i<=A;i++){
	            if(prefix[i]==A){
	                count++;
	                break;
	            }
	        }
	        HashSet<Long> hs=new HashSet<Long>();
	        for(int i=1;i<=A;i++){
	            hs.add(prefix[i]);
	        }
	        for(int i=2;i<=A;i++){
	            long search= A+prefix[i-1];
	            if(hs.contains(search)){
	                count++;
	            } 
	        }
	        int mod= (int)(Math.pow(10,9)+7);
	        return (int)(count%mod);
	    }
	  public static void main(String[] args){
		  System.out.println(solve(100000));
	  }
}

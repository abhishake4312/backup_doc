package datastructure;

import java.util.HashMap;
import java.util.Map;


public class CountSum0 {
	   public static int solve(int[] A) {
	        int n=A.length;
	        HashMap<Long,Integer> hm = new HashMap<Long,Integer>();
	        int mod=(int)(Math.pow(10,9)+7);
	        long[] prefix=new long[n];
	        prefix[0]=A[0];
	        for(int i=1;i<n;i++){
	            prefix[i]=prefix[i-1]+A[i];
	        }
	        for(int i=0;i<n;i++){
	            long key=prefix[i];
	            System.out.println("key"+key);
	            if(hm.containsKey(key)){
	                int val=hm.get(key);
	                hm.put(key,val+1);
	            }else{
	            	System.out.println("enters else");
	                hm.put(key,1);
	            }
	        }
	   //     for(Map.Entry<Long,Integer>e : hm.)
	        System.out.println(prefix[0]);
	        System.out.println(hm.containsKey((long)0));
	        long count=0;
	        if((hm.containsKey(0)) && ((hm.get(0))==1)){
	            count++;
	        }
	      
	      for(Map.Entry<Long,Integer> e:hm.entrySet()){
	          long key=e.getKey();
	          int val=e.getValue();
	          if(val>=2){
	              if(key!=0){
	                  val=val-1;
	              }
	              count = (count+ val*(val+1)/2)%mod;
	          }
	      }
	        return (int)count;
	    }
	   public static void main(String[] args){
		   int[] a={0};
		   System.out.println(solve(a));
	   }
}

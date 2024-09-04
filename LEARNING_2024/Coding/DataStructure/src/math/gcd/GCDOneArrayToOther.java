package math.gcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GCDOneArrayToOther {
	
	 public static void solve(int[] A) {
	        int n=A.length;
	        int m=(int)(Math.sqrt(n));
	        int ret[] = new int[m];

	        Arrays.sort(A);
	        

	        HashMap<Integer,Integer> hm =new HashMap<Integer,Integer>();
	        for(int i=0;i<n;i++){
	            int key= A[i];
	            if(hm.containsKey(key)){
	                int val=hm.get(key);
	                hm.put(key,val+1);
	            }else{
	                hm.put(key,1);
	            }
	        }
	        HashMap<Integer,Integer> hm2=new HashMap<Integer,Integer>();
	        hm2.put(A[n-1],1);
	        ArrayList<Integer> al = new ArrayList<Integer>();
	        al.add(A[n-1]);
	     
	        for(int x=n-2;x>=0;x--){
	            int check=A[x];
	            int count=0;
	            if(hm.containsKey(check)){
	                count=hm.get(check);
	            }
	           System.out.println("check" +check+ " and count"+count);
	           for(Map.Entry<Integer, Integer> e:hm2.entrySet()){
		        	System.out.println("key"+e.getKey()+ " value"+ e.getValue());
		        }
	            if((hm2.containsKey(check) && hm2.get(check)<count)|| !(hm2.containsKey(check))){
	            	
	            	if(hm2.containsKey(check)){
          			  hm2.put(check, hm.get(check)+1);
          		  }else{
          			  hm2.put(check,1);
          		  }
	            	System.out.println("check"+ check+"count"+hm2.get(check));
	            	  
	            	  for(int i=0;i<al.size();i++){
	            		  
	            		  int gcd=gcd(check,al.get(i));
	            		 
	            		  if(hm2.containsKey(gcd)){
	            			  int val= hm.get(gcd);
	            			  hm2.put(gcd, val+2);
	            		  }else{
	            			  hm2.put(gcd,2);
	            		  }
	            		  System.out.println(gcd+" hm.get(gcd)"+hm2.get(gcd));
	            	  }
	                  al.add(check);
	          //        hm.put(check, hm.get(check)-1);  
	            }
	            for(Map.Entry<Integer, Integer> e:hm2.entrySet()){
		        	System.out.println("key"+e.getKey()+ " value"+ e.getValue());
		        }
	        }
	       
	        int k=0;
	        for(int i=0;i<al.size();i++){
	            System.out.println(al.get(i));
	        }
	      
	    }
	   static int gcd(int A,int B){
	        if(A==0){
	            return B;
	        }
	        return gcd(B%A,A);
	    }
	  public static void main(String[] args){
		  int[] arr= {46,1,2,1,1,1,5,45,1,1,2,5,1,40,1,1,1,1,1,1,1,1,1,31,1 };
		  solve(arr);
	  }
}

package datastructure.String;

import java.util.Arrays;

public class Permutation_rank {
	 public static int findRank(String A) {

	        int n=A.length();
	        // int[] prefixCount=new int[26];

	        // for(int i=0;i<n;i++){
	        //     int index=A.charAt(i)-97;
	            
	        //         prefixCount[index]=1;
	            
	        // }
	        // for(int i=1;i<26;i++){
	            
	        //         prefixCount[i]=prefixCount[i-1]+1;
	            
	        // }
	        String sorted=A;
	        char []arr = sorted.toCharArray(); 
	        Arrays.sort(arr); 
	        sorted=String.valueOf(arr);
	        long count=1;
	        int mod=1000003;
	        for(int i=0;i<n;i++){
	            //  int index= A.charAt(i)-97;
	            //  int smallerCount=prefixCount[index]-1;
	             int smallerCount= sorted.indexOf(A.charAt(i));

	             count = (count+ smallerCount*factorial(n-i-1,mod))%mod;
	             System.out.println("count"+count);
	          int size=sorted.length();
	          System.out.println("smallercount"+smallerCount);
	          System.out.println(sorted);
	          if(size==1){
	              sorted="";
	          }else if(smallerCount==0){
	              sorted=sorted.substring(1,size);
	          }else if(smallerCount==size-1){
	              sorted= sorted.substring(0,size);
	          }else{
	              sorted=sorted.substring(0,smallerCount)+sorted.substring(smallerCount+1,size);
	          }
	          System.out.println("sorted after"+sorted);
	         
	        }
	        return (int)count;
	    }
	   static int factorial(int a,int mod){
	        int ret=1;
	        for(int i=1;i<=a;i++){
	            ret= (ret*i)%mod;
	        }
	        System.out.println("ret"+ret);
	        return ret;
	    }
	    public static void main(String[] args){
	    	System.out.println(findRank("acb"));
	    }
}

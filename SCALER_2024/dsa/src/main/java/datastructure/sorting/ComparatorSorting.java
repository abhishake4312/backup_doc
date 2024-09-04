package datastructure.sorting;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class ComparatorSorting {
    public static Integer[] solve(Integer[] A) {
    
//    Integer[] obj = new Integer[A.length];

//        for(int i = 0; i < A.length; i++) {
//            obj[i] = Integer.valueOf(A[i]); // returns Integer value
//        }
        Arrays.sort(A,new Comparator<Integer>(){
        	   public int compare(Integer a,Integer b){
        	        int factorA= countFactor(a);
        	        int factorB=countFactor(b);

        	     if(factorA==factorB){
        	    	 return a-b;
        	     }
        	     else{
        	   return factorA-factorB;
        	     }

        	
        }});
      
        return A;
    }
    static int countFactor(int a){

        int count=0;
        int i=1;
        for(;i<= Math.sqrt(a);i++){
            if(a%i==0){
                count+=2;
            }
        }
        if(((i-1)*(i-1))==a){
            count--;
        }

        return count;
    }
    
    public static void main(String[] args){
    	
    	Integer[] a = {36,13,13,26,37,28,27,43,7};
    	System.out.println("Unsorted ");
    	for(int i=0;i<a.length;i++){
    		System.out.print(a[i]+" ");
    	}
    	
    	solve(a);
    	System.out.println();
    	System.out.println("sorted ");
    	
    	for(int i=0;i<a.length;i++){
    		System.out.print(a[i]+" ");
    	}
    }

  
}

 


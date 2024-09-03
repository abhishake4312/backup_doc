package datastructure.binary_search;

public class SQRT_floor {
	  public static int sqrt(int A) {

	        int i=0;
	        if(A==0 || A==1){
	            return A;
	        }
	        for(;i<=A;i++){
	            if(i*i>A){
	                break;
	            }
	        }
	        return i-1;
	    }
	  public static void main(String[] args){
		  System.out.println(sqrt(40));
	  }
}

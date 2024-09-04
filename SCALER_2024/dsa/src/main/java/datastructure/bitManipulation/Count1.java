package datastructure.bitManipulation;

public class Count1 {
	 public static int[] countBits(int n) {
	        int[] ret=new int[n+1];

	        for(int i=0;i<=n;i++){
	            int c=0;
	            // for(int j=0;j<31;j++){
	            //     if((i&(1<<j))!=0){
	            //         c++;
	            //     }
	            // }
	            while(i>0){
	            	System.out.println(i);
	                if((i&1)==1){
	                    c++;
	                }
	                i=i/2;
	                System.out.println(i);
	            }
	            ret[i]=c;
	        }
	        return ret;
	    }
	 public static void main(String[] args){
		 int[] arr= countBits(1);
		 for(int i=0;i<arr.length;i++){
			 System.out.println(arr[i]);
		 }
	 }
}

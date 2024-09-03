package datastructure;

import java.util.ArrayList;


public class KadenProblem1 {
	 public static  int[] flip(int[] A) {

	        int count1=0;
	        int maxCount1=0;
	        int left=-1;
	        int right=-1;
	        ArrayList<Integer> al = new ArrayList<Integer>();
	        al.add(left);
	        al.add(right);
	        for(int i=0;i<A.length;i++){

	            if(A[i]==0){
	                count1++;
	            }else{
	                count1--;
	            }
	            if(count1>maxCount1){
	                al.set(0,left+1);
	                al.set(1,right+1);
	                maxCount1=count1;
	            }
	            if(count1<0){
	                left=i;
	                right=i;
	                count1=0;
	            }else{
	                right++;
	            }
	        }
	       
	        if(maxCount1==0){
	            
	             int[] arr2 =new int[0];
	            return arr2;
	        }
	        int[] arr =new int[al.size()];
	         
	        arr[0]=al.get(0);
	        arr[1]=al.get(1);
	        return arr;
	    }
	 public static void main(String[] args){
		 int[] A = {0,0,1,1,1,0,0,0};
		 int[] arr=flip(A);
		 System.out.println(arr[0]+" "+arr[1]);
	 }
	
}

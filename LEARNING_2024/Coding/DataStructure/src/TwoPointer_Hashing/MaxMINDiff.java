package TwoPointer_Hashing;

public class MaxMINDiff {
	   public static int minimize(final int[] A, final int[] B, final int[] C) {

	        int i=0;
	        int j=0;
	        int k=0;
	        int diffMin=Integer.MAX_VALUE;

	        while(i<A.length && j<B.length && k<C.length){
	                int max=Math.max(A[i],Math.max(B[j],C[k]));
	                int min=Math.min(A[i],Math.min(B[j],C[k]));
	                System.out.println("max "+max);
	                System.out.println("min "+min);
	          
	              
	            int diff= max-min;
	            if(diff>0){
	                if(diff<diffMin){
	                    diffMin=diff;
	                }
	                     if(min==A[i] ){
	                            i++;
	                        }else if(min==A[j]){
	                            j++;
	                        }else if(min==A[k]){
	                            k++;
	                        }
	                     System.out.println("i "+i+" j "+j+" k "+k);
	            }else{
	                if((0-diff)<diffMin){
	                    diffMin=0-diff;
	                }
	                  if(max==A[i] ){
	                        i++;
	                    }else if(max==A[j]){
	                        j++;
	                    }else if(max==A[k]){
	                        k++;
	                    }
	            }
	        }
	        return diffMin;
	    }
	   public static void main(String[] args){
		   int[] A={1,4,10};
		   int[] B={2,15,20};
		   int[] C={10,12};
		   System.out.println(minimize(A,B,C));
	   }
}

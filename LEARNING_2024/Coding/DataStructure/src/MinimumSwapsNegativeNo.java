
public class MinimumSwapsNegativeNo {
	  public static int solve(int[] A, int B) {

	        int ws=0;
	        for(int i=0;i<A.length;i++){
	            if(A[i]<=B){
	                ws++;
	            }
	        }
	        System.out.println("range"+ws);
	        int badCount=0;
	        for(int i=0;i<ws;i++){
	            if(A[i]>B){
	                badCount++;
	            }
	        }
	        int min=badCount;
	        System.out.println("badcount"+badCount);
	        int s=1;
	        int e=ws;
	        while(e<A.length){
	            int badIn=0;
	            int badOut=0;
	            if(A[e]>B){
	                badIn+=1;
	            }
	            if(A[s-1]>B){
	                badOut+=1;
	            }
	           badCount=badCount+badIn-badOut;
	           min=Math.min(badCount,min);
	           s++;
	           e++;
	        }
	        return min;

	    }
	public static void main(String[] args){
		
		int[] A ={52,7,93,47,68,26,51,44,5,41,88,19,78,38,17,13,24,74,92,5,84,27,48,49,37,59,3,56,79,26,55,60,16,83,63,40,55,9,96,29,7,22,27,74,78,38,11,65,29,52,36,21,94,46,52,47,87,33,87,70};
		System.out.println(solve(A,19));
	}
}

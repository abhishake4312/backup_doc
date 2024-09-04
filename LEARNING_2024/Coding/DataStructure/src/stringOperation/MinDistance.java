package stringOperation;



public class MinDistance {
	 public int solve(String A) {

		    int prev=-1;
	        int min = Integer.MAX_VALUE;
	        int flag=0;

	        for(int i=0;i<A.length();i++){

	            if(prev==-1){
	                if(A.charAt(i)=='x' || A.charAt(i)=='o'){
	                    prev=i;
	                }
	            }
	            else if((A.charAt(i)=='x' && A.charAt(prev)=='o') || (A.charAt(i)=='o' && A.charAt(prev)=='x') ){
	                
	               
	                int diff=i-prev;
	                if(diff<min){
	                    min=diff;
	                }
	                prev=i;
	                flag=1;
	            }
	            else if((A.charAt(i)=='x' && A.charAt(prev)=='x') || (A.charAt(i)=='o' && A.charAt(prev)=='o')){
	                prev=i;
	            }
	        }
	if(flag==0){
	    return -1;
	}
	return min;
	    }
		public static void main(String args[]){
			MinDistance bs= new MinDistance();
			System.out.println(bs.solve("xo"));
		
		}
}

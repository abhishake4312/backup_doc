package datastructure;

public class AGModuleOperation {
	 public int solve(String A) {
	        char[] c = A.toCharArray();
	        int countA=0;
	        long countAG=0;
	        for(int i=0;i<c.length;i++){
	           if(c[i]=='A'){
	              countA++;
	           }else if(c[i]=='G'){
	               
	               countAG+=countA;
	           }
	        }
	        int x= (int) (Math.pow(10,9)+7);
	        countAG=countAG%x;
	        
	        return (int)countAG;
	    }
	 public static void main(String[] args){
		 AGModuleOperation a= new AGModuleOperation();
		System.out.println( a.solve("AAAGGG"));
	 }
}

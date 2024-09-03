package datastructure.stringOperation;

public class AllSubStringInANumber {

	//first find size of a number
	
	public static void main(String[] args){
		
		int n = 12345;
		
		int x = (int)Math.log10(12345);
		System.out.println("x is"+x);
		
		int nCopy=n;
		int count=0;
		while(n>0){
			n=n/10;
			count++;
		}
		while(nCopy>0){
			
		for(int i=1;i<=count;i++){
			int sub= (int) (nCopy%Math.pow(10, i));
			System.out.println(sub);
		}
		nCopy=nCopy/10;
		count--;
	   }
	}
}

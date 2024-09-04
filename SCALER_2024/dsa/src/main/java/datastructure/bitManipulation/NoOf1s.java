package datastructure.bitManipulation;

public class NoOf1s {
	
	static int findNOf1(int a){
		
		
		int c=0;
		while(a>0){
			if((a&1)==1){
				c++;
			}
			a=a>>1;
		}
		return c;
	}

	public static void main(String[] args){
		System.out.println(findNOf1(10));
	}
}

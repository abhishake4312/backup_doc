package bitManipulation;

public class Add2Withoutoperator {

	
	static int sum(int a,int b){
		
		while(a!=0){
			int carry=a&b;
			b=a^b;
			a=carry<<1;
		}
		return b;
	}
	
	static int sub(int a,int b){
		b=0-b;
		return sum(a,b);
	}
	public static void main(String[] args){
		int sum = sum(20,40);
		System.out.println(sum);
		
		int sum2= sum(20,-50);
		System.out.println(sum2);
		
		int diff= sub(50,20);
		System.out.println(diff);
		
		int diff2 = sub(20,50);
		System.out.println(diff2);
	}
}

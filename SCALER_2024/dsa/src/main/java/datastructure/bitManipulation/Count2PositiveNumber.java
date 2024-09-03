package datastructure.bitManipulation;

public class Count2PositiveNumber {

	static int idea1(int a ,int b){
		
		int carry=0;
		int ret=0;
		for(int i=0;i<31;i++){
			int val1= (a&(1<<i))!=0?1:0;
			int val2= (b&(1<<i))!=0?1:0;
			int sum = (val1+val2+carry)%2;
			if(sum==1){
				ret=ret+(1<<i);
			}
			carry= (val1+val2+carry)/2;
		}
		return ret;
	}
	static int idea2(int a,int b){
		
		int ret=0;
		for(int i=0;i<31;i++){
			int count1=0;
			if((a&(1<<i))!=0){
				count1++;
			}
			if((b&(1<<i))!=0){
				count1++;
			}
			
			ret= ret + count1*(1<<i);
		}
		return ret;
	}
	public static void main(String[] args){
		
		int sum1= idea1(10,20);
		System.out.println(sum1);
		
		int sum2=idea2(10,20);
		System.out.println(sum2);
	}
}

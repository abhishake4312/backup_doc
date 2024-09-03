package datastructure.bitManipulation;

public class Add4NumbersDifferent {
  
	static int sumBinaryWise(int[] a){
		
		int sum=0;
		for(int i=0;i<31;i++){
			int count1=0;
			for(int j=0;j<a.length;j++){
				if((a[j]&(1<<i))!=0){
					count1++;
				}
			}
			sum+= count1*(1<<i);
		}
		return sum;
	}
	static int sumBinaryWiseUsingCarry(int[] a){
		
		int sum=0;
		int carry=0;
		for(int i=0;i<31;i++){
			int count1=0;
			for(int j=0;j<a.length;j++){
				if((a[j]&(1<<i))!=0){
					count1++;
				}
			}
			
			count1=count1+carry;
			int val= count1%2;
			carry=count1/2;
			sum+=val*(1<<i);
			
		}
		return sum;
	}
	
	public static void main(String[] args){
		int[] a= { 46,45,3,73};
		int sum=0;
		for(int i=0;i<a.length;i++){
			sum+=a[i];
			
		}
		System.out.println(sum);
		System.out.println(sumBinaryWise(a));
		System.out.println(sumBinaryWiseUsingCarry(a));
	}
}

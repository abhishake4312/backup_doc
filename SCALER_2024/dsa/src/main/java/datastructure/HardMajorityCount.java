package datastructure;

public class HardMajorityCount {
	
	static int majorityCount(int[] a){
		
		int n=a.length;
		
		int majority=a[0];
		int count=1;
		
		for(int i=1;i<n;i++){
			if(majority==0 && count==0){
				majority=a[i];
				count=1;
			}else if(majority==a[i]){
				count++;
			}else if(majority!=a[i]){
				count--;
				if(count==0){
					majority=0;
				}
			}
		}
		
		int countFinal=0;
		for(int i=0;i<n;i++){
			if(a[i]==majority){
				countFinal++;
			}
		}
		if(countFinal>n/2){
			return majority;
		}else{
			return -1;
		}
		
	}
	
	public static void main(String[] args){
		
		int a[] = { 0,0,2,2,0,0,5};
		System.out.println(majorityCount(a));
		
	}

}

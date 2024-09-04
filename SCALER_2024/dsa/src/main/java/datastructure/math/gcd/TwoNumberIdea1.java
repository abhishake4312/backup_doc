package datastructure.math.gcd;

public class TwoNumberIdea1 {
    
	// TC O(min(a,b)  SC:O(1)
	public static int findGCD(int a ,int b){
		
		if(a==0 || b==0){
			return a+b;
		}
		int ans=1;
		int min=Math.min(a,b);
		
		for(int i=1;i<=min;i++){
			if(a%i==0 && b%i==0){
				ans=i;
			}
		}
		return ans;
	}
	
	public static int findGCDsqrt(int a , int b){
		
		if(a==0 || b==0){
			return a+b;
		}
		int ans=1;
		int min=Math.min(a,b);
		int max=Math.max(a,b);
		
		for(int i=1;i<=Math.sqrt(min);i++){
			
			if(min%i==0){
				int fact2=min/i;
				
				if(max%i==0){
					ans=i;
				}
				if(max%fact2==0){
					ans=fact2;
					break;
				}
			}
		}
		return ans;
	}
	
	// TC <=O(log(max(a,b))
	public static int findGCDEuclidSubstract(int a,int b){
		if(a==0 || b==0){
			return a+b;
		}
		while(a!=0 && b!=0){
			if(a<=b){
				b=b-a;
			}else{
				a=a-b;
			}
		}
		return a+b;
	}
	public static int findGCDEuclidMod(int a,int b){
		if(a==0 || b==0){
			return a+b;
		}
		while(a!=0 && b!=0){
			if(a<=b){
				b=b%a;
			}else{
				a=a%b;
			}
		}
		return a+b;
	}
	
	public static int recursion(int a,int b){
		if(a==0){
			return b;
		}
		return recursion(b%a,a);
	}
	public static void main(String[] args){
		
		int a=48;
		int b=21;
		int x= findGCD(a,b);
		int y= findGCDsqrt(a,b);
		int z= findGCDEuclidSubstract(a,b);
		int k= findGCDEuclidMod(a,b);
		int recursion= recursion(a,b);
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(k);
		System.out.println(recursion);
	}
}


public class PrimeNumber {

	void printPrime(int n){
		
		
		for(int i=n;i>=2;i--){
			int flag=0;
			for(int j=2;j<=i/2;j++){
				
				if(i%j==0){
					flag=1;
					break;
				}
			}
			if(flag==0){
				System.out.println("prime number "+i);
			}
			
		}
	}
	
	public static void main(String[] args){
		PrimeNumber p = new PrimeNumber();
		p.printPrime(20);
	}
}

package datastructure.String;

public class ConvertStringIntoIntVal {

	public static void main(String[] args){
		
		String s1="ac";
		int mod= (int)(Math.pow(10, 9)+7);
		int p=29;
		long valueInt=0;
		int n=s1.length();
		for(int i=0;i<n;i++){
			valueInt = (long) (valueInt + (s1.charAt(i)*Math.pow(p, n-1-i))%mod);
		}
		  long valueB=0;
	        long initial=1;
		 for(int i=n-1;i>=0;i--){
	            valueB= (valueB+ s1.charAt(i)*initial)%mod;
	            initial = (29*initial)%mod;
	        }
		System.out.println(valueInt);
		System.out.println(valueB);
	}
}

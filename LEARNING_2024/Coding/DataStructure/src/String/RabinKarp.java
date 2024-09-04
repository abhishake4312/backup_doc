package String;

public class RabinKarp {
	  public static int solve(String A, String B) {

	        int mod= (int)(Math.pow(10,9)+7);
	        int p=29;
	        int n=A.length();
	        int m=B.length();
	        long valueB=0;
	        long initial=1;
	        long valueA=0;
	        for(int i=m-1;i>=0;i--){
	            valueB= (valueB+ B.charAt(i)*initial)%mod;
	            initial = (p*initial)%mod;
	        }
	        System.out.println("valueB "+valueB);
	          initial=1;
	          
	        for(int i=m-1;i>=0;i--){
	            valueA= (valueA+ A.charAt(i)*initial)%mod;
	            initial = (p*initial)%mod;
	        }
	        System.out.println("valueA "+valueA);
	        int count=0;
	        if(valueA==valueB){
	            count++;
	        }
	        int j=m;
	        int i=1;
	        while(j<n){
	            long in= A.charAt(j);
	            long out= ((long)A.charAt(i-1)*fastPower(p,m,mod))%mod;
	            System.out.println("out "+out);
	            valueA= (valueA*p)%mod - out+in;
	            System.out.println("valueA "+valueA);
	            if(valueA==valueB){
	                count++;
	            }
	            j++;
	            i++;
	        }
	        return count;

	    }
	     static int fastPower(int a,int p,int mod){
	        if(p==0){
	            return 1;
	        }
	        if(p%2==0){
	            long val= fastPower(a,p/2,mod);
	            return (int)((val*val)%mod);
	        }else{
	            long val= fastPower(a,p/2,mod);

	            return (int)(a*((val*val)%mod)%mod);
	        }
	    }
	     public static void main(String[] args){
	    	 String A="ccbcdaacc";
	    	 String B="ac";
	    	 System.out.println(solve(A,B));
	     }
}

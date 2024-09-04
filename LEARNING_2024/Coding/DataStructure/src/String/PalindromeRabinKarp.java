package String;

public class PalindromeRabinKarp {
	  public static int solve(String A) {
	        int n=A.length();
	        int mod= (int)(Math.pow(10,9)+7);
	        int p=29;
	        long front= 0;
	        long back=0;
	        for(int i=0;i<n;i++){
	            front = (front + A.charAt(i)*fastPower(p,n-1-i,mod))%mod;
	            back = (back + A.charAt(i)*fastPower(p,i,mod))%mod;
	        }
	        System.out.println("front "+front);
	        System.out.println("back "+back);
	        int val=0;
	        if(front==back){
	            return val;
	        }
	   
	        long frontsub=0;
	        long backsub=0;
	        for(int i=0;i<n;i++){
	            int charVal= A.charAt(n-1-i);
	            frontsub = (frontsub*p+ charVal*fastPower(p,n,mod))%mod;
	            long frontnew = (front+frontsub)%mod;
	            backsub= (backsub+A.charAt(n-1-i)*fastPower(p,i,mod))%mod;
	            long backnew = (backsub+ (fastPower(p,i+1,mod)*back)%mod)%mod;
	             if(frontnew==backnew){
	                 val=i+1;
	                 break;
	                }
	        }
	      return val;
	    }
	    static long fastPower(int a, int p, int mod){
	        if(p==0){
	            return 1;
	        }
	        if(p%2==0){
	            long val = fastPower(a,p/2,mod);
	            return (val*val)%mod;
	        }else{
	             long val = fastPower(a,p/2,mod);
	             return (a*((val*val)%mod))%mod;
	        }
	    }
	    public static void main(String[] args){
	    	System.out.println(solve("abc"));
	    }
}

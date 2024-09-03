package datastructure;

public class Factorial {
	  static int fact(int n)
      {
          if(n==0)
          return 1;
            int mod= (int)(Math.pow(10,9)+7);
          long res = 1;
          for (int i = 2; i <= n; i++)
              res = (res * i)%mod;
              
          return (int)(res%mod);
      }
	  public static void main(String[] args){
		  System.out.println(fact(15));
	  }
}

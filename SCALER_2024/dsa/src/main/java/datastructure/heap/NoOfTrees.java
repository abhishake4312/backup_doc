package datastructure.heap;


public class NoOfTrees {
    public static int solve(int A) {

        return calculated( A);
    }

    static  int calculated(int n){
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        int H= (int)(Math.log(n)/Math.log(2));
        System.out.println("height"+H);
        int mod= (int)(Math.pow(10,9)+7);
        int x= fastpower(2,H,mod)-1;
        System.out.println("no of nodes till 2nd last"+x);
        int last= Math.min(n-x,(x+1)/2);
        int lst= ((x-1)/2)+last;
        int rst= n-1-lst;
        System.out.println("lst"+lst+" rst"+rst);
        int ncr= nCr(n-1,lst);
        return ncr*calculated(lst)*calculated(rst);
    }
    static   int fastpower(int a,int p,int mod ){
        if(p==0){
            return 1;
        }
        long val= fastpower(a,p/2,mod);
        if(p%2==0){
            return (int)((val*val)%mod);
        }else{

            return  (int)((a*((val*val)%mod))%mod);
        }
    }
    static int nCr(int n, int r)
        {
            return fact(n) / (fact(r) * fact(n - r));
        }
        
        // Returns factorial of n
    static int fact(int n)
        {
            if(n==0)
            return 1;
            int res = 1;
            for (int i = 2; i <= n; i++)
                res = res * i;
            return res;
        }
    public static void main(String[] args){
    	System.out.println(solve(3));
    }
}

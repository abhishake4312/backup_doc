package datastructure.backtrack;

public class DistinctPermutationPrint {
	    static int[][] ret;
	    static int p=0;
	    public static void permute(int[] A) {
	        int n=A.length;
	        int m=factorial(n);
	         ret= new int[m][n];
	        int[] ans=new int[n];
	    
	        int itr=0;
	        int[] visited=new int[n];
	        findPermutation(A,ans,n,itr,visited);
	        for(int i=0;i<m;i++){
	        	for(int j=0;j<n;j++){
	        		System.out.print(ret[i][j]);
	        	}
	        }
	       // return ret;
	    }
	    static int factorial(int n){
	        if(n==1){
	            return 1;
	        }
	        return n*factorial(n-1);
	    }

	    static void findPermutation(int[] A,int[] ans ,int n,int itr,int[] visited ){
	        if(itr==n){
	            
	            ret[p]=ans;
	            p++;
	            return;
	        }
	        for(int i=0;i<n;i++){
	            if(visited[i]==0){
	                visited[i]=1;
	                ans[itr]=A[i];
	                findPermutation(A,ans,n,itr+1,visited);
	                visited[i]=0;
	            }
	        }
	    }
	
		public static void main(String[] args){
			int[] arr={1,2,3};
			permute(arr);
		
		}
}

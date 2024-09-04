package binary_search;

public class FindMedianInMatrix {
	  public static int findMedian(int[][] A) {
	        int n=A.length;
	        int m=A[0].length;
	        int valueLessEqual= ((n*m)/2)+1;
	         int ret=0;
	     
	         int max=Integer.MIN_VALUE;
	         for(int i=0;i<n;i++){
	             for(int j=0;j<m;j++){
	                 max=Math.max(max,A[i][j]);
	             }
	         }
	        System.out.println("max"+ max);

	            int l=1; 
	            int h=max;
	            while(l<=h){
	                int mid=(l+h)/2;
	                int count=0;
	                for(int j=0;j<n;j++){ 
	                    count=count+ binarysearch(mid,A[j]);       
	                } 
	                System.out.println(" mid "+mid+" count"+count);
	                if(count<valueLessEqual){
	                    l=mid+1;
	                }else{
	                    
	                    ret=mid;  
	                    h=mid-1;
	                }
	            
	        }
	        return ret;
	    }

	   static int binarysearch(int B,int[] A){
	        int s=0;
	        int e=A.length-1;
	        int ans=-1;
	        while(s<=e){
	            int mid= (s+e)/2;
	          
	            if(A[mid]>B){
	                e=mid-1;
	            }else{
	            	ans=mid;
	                s=mid+1;
	            }
	        }
	        return ans+1;
	    }
	    public static void main(String[] agrs){
	    	int[][] a={{2,3,8},{4,8,10},{4,7,9},{2,8,10},{1,2,8},{4,4,4},{3,8,9}};
	    	System.out.println(findMedian(a));
	    }
}

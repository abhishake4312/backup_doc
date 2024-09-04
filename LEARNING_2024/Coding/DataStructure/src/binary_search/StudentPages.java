package binary_search;

public class StudentPages {
	 public static int books(int[] A, int B) {

	        int maxPages=0;
	        int n=A.length;
	        for(int i=0;i<n;i++){
	            maxPages+=A[i];
	        }
	        System.out.println(maxPages);
	        int h=maxPages;
	        int l=1;
	        int ans=-1;
	        if(B>n){
	            return ans;
	        }
	        while(l<=h){
	            int mid=(l+h)/2;
	            System.out.println("l "+l+" h"+h+" mid"+mid);
	            int maxstudent=maxStudentAtleastPages(A,mid);
	            System.out.println("maxstudent"+maxstudent);
	            if(maxstudent<B){
	                h=mid-1;
	            }else{
	               ans=mid;
	               l=mid+1;
	            }
	        }
//	        return ans;
	        System.out.println("answer now"+ans);
	        int maxMIN=ans;
	        int req=ans;
	        int student=0;
	        int i=0;
	        for( i=0;i<n;i++){
	        	
	        	if(student==B-1){
	        		break;
	        	}
	        	if(req==ans && A[i]>=ans){
	        		maxMIN=Math.max(maxMIN,A[i]);
	        		student++;
	        	}else if( A[i]<req){
	        		req=req-A[i];
	        	}else if( req<ans && A[i]>=req){
	        		maxMIN=Math.max(maxMIN,A[i]-req+ans);
	        		req=ans;
	        		student++;
	        	}
	        	System.out.println("maxMIN"+maxMIN);
	        }
	        int sum=0;
	        for(int j=i;j<n;j++){
	        	sum+=A[j];
	        	
	        }
	        maxMIN=Math.max(maxMIN,sum);
	        System.out.println("maxMIN"+maxMIN);
	        return maxMIN;
	    }
	    public static  int maxStudentAtleastPages(int[] A, int pages){
	          int ans=0;
	          int n=A.length;
	          int sum=0;
	        for(int i=0;i<n;i++){
	            sum =sum+A[i];
	           if(sum>=pages){
	        	   ans++;
	        	   sum=0;
	           }
	          
	        }
	        return ans;
	    }
	    
	    public static void main(String[] args){
	    //	int[] arr= {73,58,30,72,44,78,23,9};
	    //	int[] arr={12,34,67,90};
	    	int[] arr={5,82,52,66,16,37,38,44,1,97,71,28,37,58,77,97,94,4,9};
	    	System.out.println(books(arr,16));
	    	
	    }
}

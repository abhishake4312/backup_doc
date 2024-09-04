package datastructure;

public class TWODSubArrays {

	
	public static void main(String[] args){
		
		        int[] A={1,2,3};
		       
		            
		            int n=A.length;
		            int[][] arr=new int[n*(n+1)/2][n];
                    int m=0;
		            for(int i=0;i<n;i++){
		                for(int j=i;j<n;j++){
		                    int[] innerArray=new int[j-i+1];
		                    int count=0;
		                    for(int k=i;k<=j;k++){
		                        innerArray[count]=A[k];
		                        count++;
		                    }
		                    arr[m]=innerArray;
		                    m++;
		                   
		                }
		            }
		            
		           for(int[] row:arr){
		        	   for(int x :row){
		        		   System.out.print(x+" ");
		        	   }
		        	   System.out.println();
		           }
		        }
		     
		    
	}


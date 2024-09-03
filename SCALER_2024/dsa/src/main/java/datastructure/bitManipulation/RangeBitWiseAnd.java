package datastructure.bitManipulation;

public class RangeBitWiseAnd {
	 public static int rangeBitwiseAnd(int left, int right) {
	        int ans=0;
	        
	        int msbleft=0;
	        int msbright=0;
	        for(int i=30;i>=0;i--){
	            if((left&(1<<i))!=0){
	               msbleft=i;
	               break;
	            }
	        }
	        for(int i=30;i>=0;i--){
	            if((right&(1<<i))!=0){
	               msbright=i;
	               break;
	            }
	        }
	        if(msbright!=msbleft){
	            return 0;
	        }
	        else{
	        	System.out.println("enters else");
	        	System.out.println("left"+left);
	        	System.out.println("right"+right);
//	            for(int i=0;i<31;i++){
//	                int count0=0;
	                for(int j=2147483646;j<=2147483647;j++){
	                	System.out.println("value of j"+j);
//	                    if((j&(1<<i))==0){
//	                    	
//	                        count0+=1;
//	                        break;
//	                    }
	                }
//	                if(count0==0){
//	                    ans=ans+(1<<i);
//	                }
//	            }
	             return ans;
	        }
	       

	       
	    }
	 public static void main(String[] args){
	//	 int val=rangeBitwiseAnd(2147483646,2147483647);
		 int val=rangeBitwiseAnd(8,15);
		 System.out.println(val);
	 }
}

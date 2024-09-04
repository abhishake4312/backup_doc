

public class CarryForwardMinMax {
    public int solve(int[] A) {

        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for(int i=0;i<A.length;i++){
            if(A[i]<min){
                min=A[i];
            }
            if(A[i]>max){
                max=A[i];
            }
        }
        
        System.out.println("min max"+ min+" "+max);

        int minPrevIndex=-1;
        int retSize=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]==max){
                if(minPrevIndex!=-1){
                    int len= i-minPrevIndex+1;
                   if(len<retSize){
                       retSize=len;
                   }
                }
            }
            else if(A[i]==min){
                minPrevIndex=i;
            }
        }
        int maxPrevIndex=-1;
         
        for(int i=0;i<A.length;i++){
            if(A[i]==min){
                if(maxPrevIndex!=-1){
                    int len= i-maxPrevIndex+1;
                    if(len<retSize){
                       retSize=len;
                   }
                }

            }else if(A[i]==max){
                maxPrevIndex=i;
            }
        }

        return retSize;
    }
    public static void main(String[] args){
    	CarryForwardMinMax c= new CarryForwardMinMax();
    	int[] a= {3,2};
    	System.out.println(c.solve(a));
    

    }
}

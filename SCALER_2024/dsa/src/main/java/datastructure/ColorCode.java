package datastructure;


public class ColorCode {
    public static int[] sortColors(int[] A) {
        
        int n=A.length;
        int count0=0;
        int count1=1;
        int count2=2;

        for(int i=0;i<n;i++){
            if(A[i]==0){
                count0++;
            }else if (A[i]==1){
                count1++;
            }else{
                count2++;
            }
        }
        System.out.println("count0"+count0);
        System.out.println("count1"+count1);
        System.out.println("count2"+count2);
        int limit1= count0+count1;
        for(int i=0;i<n;i++){
            if(i<count0){
                A[i]=0;
            }else if((i>=count0) && (i<limit1)){
                A[i]=1;
            }else if(i>=limit1 && i<n){
                A[i]=2;
            }
        }
        return A;
    }
    public static void main(String[] args){
    	int[] a = {0,1,2,0,1,2};
    	int[] b=sortColors(a);
    	for(int i=0;i<b.length;i++){
    		System.out.println(b[i]);
    	}
    	
    }
}

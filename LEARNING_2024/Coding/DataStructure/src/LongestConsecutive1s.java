
public class LongestConsecutive1s {

	static int countMax1(int[] a){
		
		int prevZero=-1;
		int count=0;
		int maxCount=0;
		int n=a.length;
		for(int i=0;i<n;i++){
			
			if(a[i]==1){
				count++;
			}
			if(a[i]==0){
				count = i-prevZero;
				prevZero=i;
			}
			
			maxCount= Math.max(count, maxCount);
		}
		return maxCount;
		
	}
	
	public static void main(String[] args){
		
		int arr[] = {0,1,1,1,0,1,1,0,1,1,0};
		System.out.println(countMax1(arr));
		
	}
}

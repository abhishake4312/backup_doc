package sorting;

public class CountSort {

	static void countSort(int[] arr){
		
		int n = arr.length;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			min= Math.min(arr[i], min);
			max= Math.max(arr[i],max);
		}
		
		int len = max-min+1;
		int freq[] =new int[len];
		
		for(int i=0;i<n;i++){
			int index= arr[i]-min;
			freq[index]= freq[index]+1;
		}
		
		int k=0;
		for(int i=0;i<len;i++){
			int value = min+i;
			for(int j=0;j<freq[i];j++){
				arr[k]=value;
				k++;
			}
		}
	}
	public static void main(String[] args){
		
		int[] arr= {5,6,7,2,1,99,2,55,5,4,3,-7,-2,0};
		countSort(arr);
		System.out.println("After sorting");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}

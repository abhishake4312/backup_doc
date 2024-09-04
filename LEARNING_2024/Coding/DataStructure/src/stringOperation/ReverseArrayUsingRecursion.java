package stringOperation;

public class ReverseArrayUsingRecursion {

	void reverse(int[] arr,int i){
		int n=arr.length;
		if(i>n/2){
			return;
		}
		
		int x=arr[i];
		arr[i]=arr[n-1-i];
		arr[n-1-i]=x;
		reverse(arr,i+1);
	}
	
	public static void main(String[] args){
		ReverseArrayUsingRecursion r = new ReverseArrayUsingRecursion();
		int[] arr={5,2,6,7,8};
		r.reverse(arr, 0);
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}

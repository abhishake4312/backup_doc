package interview.epam;

public class FirstPositiveMissing {
  
	public static void main(String[] args){
		int[] arr= {1,2,3,4,5};
		int n=arr.length;
		
		for(int i=0;i<n;i++){
			
			if(arr[i]!=i && arr[i]>0 && arr[i]<n){
				int tmp= arr[i];
				arr[i]=arr[tmp];
				arr[tmp]=tmp;
			}
		}
		for(int i=1;i<n;i++){
			if(arr[i]!=i){
				System.out.println(i);
				break;
			}
		}
	}
}

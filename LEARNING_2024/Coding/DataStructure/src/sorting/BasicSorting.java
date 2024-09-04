package sorting;

public class BasicSorting {

	
	void sort(int[] arr){
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[i]){
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
	}
	
	public static void main(String args[]){
		BasicSorting bs= new BasicSorting();
		int[] arr={4,2,7,5,9,1};
		bs.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}

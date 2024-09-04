package sorting;

public class SelectionSortStable {
	
	void stable(int[] arr){
		
		
		for(int i=0;i<arr.length-1;i++){
			int minPos=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minPos]){
					minPos=j;
				}
			}
			int key=arr[minPos];
			for(int k=minPos;k>i;k--){
				arr[k]=arr[k-1];
			}
			arr[i]=key;
		}
	}
	public static void main(String args[]){
		SelectionSortStable bs= new SelectionSortStable();
		int[] arr={4,7,3,2,9};
		bs.stable(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}

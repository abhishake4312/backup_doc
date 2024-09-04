package sorting;

public class MergeSortDifferentMerge {
	static void mergeSort(int[] a,int s,int e){
		if(s<e){
			int mid=(s+e)/2;
		//	System.out.println((mid));
			mergeSort(a,s,mid);
			mergeSort(a,mid+1,e);
			merge(a,s,mid,e);

		}
	}
	static void merge(int[] a ,int s ,int mid,int e){
	//	System.out.println("s,mid,e"+s+" "+mid+" "+e);
		int leftSize= mid-s+1;
		int[] left=new int[leftSize];
		
		int rightSize= e-mid;
		int[] right = new int[rightSize];
		
		for(int i=0;i<leftSize;i++){
			left[i]= a[s+i];
			System.out.println("left"+left[i]);
		}
	
		for(int j=0;j<rightSize;j++){
			right[j]=a[mid+1+j];
			System.out.println("right"+right[j]);
		}
	
		
		int i=0, j=0;
		for(int k=s;k<(leftSize+rightSize+s);k++){
			if(i==leftSize){
				a[k]=right[j];
				j++;
			}else if(j==rightSize){
				a[k]=left[i];
				i++;
			}else if(left[i]<=right[j]){
				a[k]=left[i];
				i++;
			}else{
				a[k]=right[j];
				j++;
			}
		}
		
		
		
	}
	public static void main(String[] args){
		int[] a = { 5,4,3,2,1};
		System.out.println("Before sort");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		mergeSort(a,0,a.length-1);
		System.out.println("After sort");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}



}

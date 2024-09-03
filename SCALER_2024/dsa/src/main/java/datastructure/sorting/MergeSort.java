package datastructure.sorting;

public class MergeSort {
	
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
		System.out.println("s,mid,e"+s+" "+mid+" "+e);
		int leftSize= mid-s+1;
		int[] left=new int[leftSize];
		
		int rightSize= e-mid;
		int[] right = new int[rightSize];
		
//		for(int i=0;i<leftSize;i++){
//			left[i]= a[s+i];
//			System.out.println("left"+left[i]);
//		}
		int itr=0;
		for(int i=s;i<=mid;i++){
			left[itr]=a[i];
			itr++;
		}
//		for(int j=0;j<rightSize;j++){
//			right[j]=a[mid+1+j];
//			System.out.println("right"+right[j]);
//		}
		int itr2=0;
		for(int i=mid+1;i<=e;i++){
			right[itr2]=a[i];
			itr2++;
		}
		
		int i=0, j=0,k=s;
		
		while(i<leftSize && j<rightSize){
			
			if(left[i]<=right[j]){
				a[k]=left[i];
				i++;
				k++;
			}else{
				a[k]=right[j];
				j++;
				k++;
			}
		}
		while(i<leftSize){
			a[k]=left[i];
			i++;
			k++;
		}
		while(j<rightSize){
			a[k]=right[j];
			j++;
			k++;
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

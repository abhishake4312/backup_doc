package datastructure;

public class TwoDArray {

	public static void main(String[] args){
		int a[][]=new int[10][10];
		for(int i=0;i<10;i++){
			int[] arr2=new int[10-i];
			int count=0;
			for(int j=i;j<10;j++){
				arr2[count]=j;
				count++;
			}
			a[i]=arr2;
		}
		for(int[] row:a){
			for(int x:row){
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}

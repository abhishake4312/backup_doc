package typecast;

public class ArraysPassing {
	static void valueChange(int[] arr){
		arr[2]=20;
	}
	
	public static void main(String[] args){
		int[] arr= {5,6,4,6,3};
		valueChange(arr);
		for(int i=0;i<5;i++){
			System.out.println(arr[i]);
		}
	}

}

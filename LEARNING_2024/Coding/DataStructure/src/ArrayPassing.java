
public class ArrayPassing {
	static void function(int[] arr){
		arr[2]=10;
	}
   public static void main(String[] args){
	   int[] arr={3,4,5};
	   function(arr);
	   for(int i=0;i<arr.length;i++){
		   System.out.println(arr[i]);
	   }
	   
   }
}

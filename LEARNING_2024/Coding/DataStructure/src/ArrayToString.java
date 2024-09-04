
public class ArrayToString {
	
	public static void main(String[] args){
		int[] a ={5,4,6,7};
		String s="";
		for(int i=0;i<a.length;i++){
			s=s+a[i];
		}
		
		int b =97;
		char c =(char)b;
		System.out.println(c);
		System.out.println(s);
	}

}

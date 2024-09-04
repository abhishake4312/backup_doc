package stringOperation;

public class StringReverseUsingRecursion {

	void reverse(char[] c,int i){
		int n=c.length;
		if(i>n/2){
			return;
		}
		char tmp=c[i];
		c[i]=c[n-1-i];
		c[n-1-i]=tmp;
		
		reverse(c,i+1);
	}
	
	public static void main(String[] args){
		StringReverseUsingRecursion s=new StringReverseUsingRecursion();
		String s1="abhishek";
		char[] c = s1.toCharArray();
		s.reverse(c, 0);
		System.out.println(String.valueOf(c));
	}
}

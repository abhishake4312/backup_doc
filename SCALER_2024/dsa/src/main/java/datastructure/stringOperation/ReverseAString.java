package datastructure.stringOperation;

public class ReverseAString {

	public static void main(String[] args){
		
		String s = "abhishek";
		int i=0;
		int j=s.length()-1;
		
		char[] c=s.toCharArray();
		while(i<j){
			char x=c[i];
			c[i]=c[j];
			c[j]=x;	
			i++;
			j--;
		}
		String rev=new String(c);
		System.out.println(rev);
	}
}

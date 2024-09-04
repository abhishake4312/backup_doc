
public class StringChar {
public static void main(String[] args){
	char[] s ={'A','b',' ','d','e'};
	
	System.out.println((char)(s[0]+32));
	System.out.println((char)(s[0]+' ')+"hi");
	System.out.println((int)s[2]);
	
	String s2=new String(s,1,3);
	System.out.println(s2);
	
	
}
}


public class StringImmutable {

	public static void main(String[] args){
		
		String s1 = new String("abhishek");
		String s2 = new String("abhishek");
		System.out.println("s1 class"+ s1.hashCode()+" s2. class"+ s1.hashCode());
	}
}

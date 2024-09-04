package stringOperation;

public class CompareToMethodImpl {
	
	static int compareToImpl(String s1,String s2){
		
		int l1=s1.length();
		int l2= s2.length();
		int i=0,j=0;
		while(i<l1 && j<l2){
			int val1=s1.charAt(i);
			int val2=s2.charAt(j);
			if(val1!=val2){
				return val1-val2;
			}
			i++;
			j++;
		}
		return l1-l2;
	}

	public static void main(String[] args){
		String s1="abhi";
		String s2="abhi5";
		System.out.println(compareToImpl(s1,s2));
		System.out.println(s1.compareTo(s2));
		
	}
}

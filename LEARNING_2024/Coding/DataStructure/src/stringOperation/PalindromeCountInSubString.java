package stringOperation;

public class PalindromeCountInSubString {

	public int countPalindromeInSubString(String s){
		
		char[] c = s.toCharArray();
		
		int count =0;
		for(int i=0;i<s.length();i++){
			String sub ="";
			for( int j=i;j<s.length();j++){
				sub+=c[j];
				if(checkPalindrome(sub)){
					count++;
				}
			}
		}
		return count;
	}
	
	public boolean checkPalindrome(String s){
		int i=0;
		int j=s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
			i++;j--;
		}
		return true;
	}
	
	public static void main(String[] args){
		PalindromeCountInSubString p = new PalindromeCountInSubString();
		System.out.println(p.countPalindromeInSubString("acbbd"));
	}
}

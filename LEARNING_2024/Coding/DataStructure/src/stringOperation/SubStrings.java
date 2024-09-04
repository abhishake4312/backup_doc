package stringOperation;

public class SubStrings {
	
	public void subString(String s){
		
		char[] c = s.toCharArray();
		
		for(int i=0;i<s.length();i++){
			String subStrings="";
			for(int j=i;j<s.length();j++){
				subStrings += c[j];
				System.out.println("subStrings "+subStrings);
			}
		}
	}

	public static void main(String[] args){
		
		SubStrings s = new SubStrings();
		s.subString("abhishek");
		
		
	}
}

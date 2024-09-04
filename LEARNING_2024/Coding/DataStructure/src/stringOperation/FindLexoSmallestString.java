package stringOperation;

public class FindLexoSmallestString {

	static String smallestWord(String[] s){
		
		
		// O(N * max(slength)
		int n=s.length;
		
		String smallest=s[0];
		for(int i=0;i<n;i++){
			String snew=s[i];
			int comp=snew.compareTo(smallest);
			if(comp<0){
				smallest=snew;
			}
		}
		return smallest;
		
	}
	public static void main(String[] args){
		String[] s={"abhu","singh","abhi","abh"};
		System.out.println(smallestWord(s));
	}
}

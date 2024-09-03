package datastructure.stringOperation;

public class CountSubStringInOtherString {

	public int countSubString(String s1, String s2){
		
		char[] c = s1.toCharArray();
		int count =0;
		
		for(int i=0;i<s1.length();i++){
			String sub="";
			for(int j=i;j<s1.length();j++){
				sub+=c[j];
				if(s2.indexOf(sub)!=-1){
					count++;
				}
			}
		}
		
		return count;
	}
	
public static void main(String[] args){
		
     	CountSubStringInOtherString s = new CountSubStringInOtherString();
		System.out.println(s.countSubString("aab","aaaab"));
		
		int x=123;
		
		
		
	}
}

import java.util.HashMap;


public class LongestSubstringWithoutRepeat {

	public static int lengthOfLongestSubstring(String s) {
	    
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		int n=s.length();
		int start=0;
		int maxlength=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			char c=s.charAt(i);
			if(hm.containsKey(c)){
				
				int prev=hm.get(c);
				if(prev>=start){
					int len=i-1-start+1;
					start=prev+1;
					maxlength=Math.max(maxlength,len);
					
				}
				hm.put(c,i);
			}else{
				hm.put(c,i);
			}
			
		}
		return maxlength;
		
	    
	}
	public static void main(String[] args){
		String a="abcabcab";
		int maxlength=lengthOfLongestSubstring(a);
		System.out.println(maxlength);
		
	}
}

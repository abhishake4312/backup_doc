package stringOperation;

import java.util.HashSet;
import java.util.Set;

public class KPeriodicSubString {

	boolean isKPeriodic(String s, int k){
		
		String sub=s.substring(0,k);
		
		Set<String> hs = new HashSet<String>();
		hs.add(sub);
		
		for(int i=k;i<=s.length()-k;i=i+k){
			String sub2= s.substring(i,i+k);
			if(!hs.contains(sub2)){
				return false;
			}
		}
		return true;
		
	}
	public static void main(String[] args){
		KPeriodicSubString p = new KPeriodicSubString();
		System.out.println(p.isKPeriodic("geeksforgeeks", 3));
		
		String s="my name is abhishek";
		System.out.println("char at"+s.charAt(2));
	}
}

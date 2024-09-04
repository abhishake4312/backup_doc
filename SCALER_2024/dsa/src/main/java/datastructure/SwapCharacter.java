package datastructure;

public class SwapCharacter {
        
	void minoperation(String a ,String b){
		int n=a.length();
		int m=b.length();
		int minoperation=0;
		if(n!=m){
			minoperation+= Math.abs(n-m);
		}else{
			int i=0;
			int j=0;
			while(i<n && j<n){
				if(a.charAt(i) != b.charAt(j) ){
					minoperation++;
				}
			}
		}
	}
	public static void main(String[] args){
		String a="abcd";
		String b="apcdg";
		
	}
	
}

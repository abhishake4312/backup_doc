package stringOperation;



public class SubStringGreaterThanX {
	
	int count(String s, int X){
		
		int size = (int)Math.log10(X)+1;
		System.out.println("size of number"+size);
		int count =0;
		for(int i=0;i<s.length()-size+1;i++){
			String sub="";
			for(int j=i+size;j<=s.length();j++){
				sub=s.substring(i,j);
				int x=Integer.parseInt(sub);
				if(x>X){
					count++;
				}
			}
		}
		return count;
		
	}

	public static void main(String[] args){
		SubStringGreaterThanX p = new SubStringGreaterThanX();
		System.out.println(p.count("2222", 47));
	}
}

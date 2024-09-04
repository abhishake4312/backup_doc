package datastructure.bitManipulation;

public class BitMask {
//             z  y  x  w  v  u  t  s  r  q  p  o  n  m  l  k  j i h g f e d c b a
//	           25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0
//			   0   0  0  0  0  0  0  0  0  0  0  0  0  0  0  0 0 0 0 0 0 0 0 0 0 0
//abhishek                           1                       1   1 1     1     1 1  (263571)
	static int createBitMask(String s){
		int ans=0;
		
		for(int i=0;i<s.length();i++){
			int bitset=s.charAt(i)-'a';
			if((ans&(1<<bitset))==0){
			//	ans=(ans^(1<<bitset));
				ans+=(1<<bitset);
			}
		}
		return ans;
	}

	public static void main(String[] args){
		
		String s1 = "abhishek";
		int bitmasks1=createBitMask(s1);
		System.out.println(bitmasks1);
		String s2=  "zxmp";
		int bitmasks2=createBitMask(s2);
		System.out.println(bitmasks2);
		
		int checkcommonletter= (bitmasks1 & bitmasks2);
		if(checkcommonletter==0){
			System.out.println("don't share common letter");
		}else{
			System.out.println("share common letter");
		}
		
	}
}

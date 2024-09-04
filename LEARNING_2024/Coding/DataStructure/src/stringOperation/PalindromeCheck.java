package stringOperation;

public class PalindromeCheck {
	
	public boolean check(String s){
		int i=0;
		int j= s.length()-1;
		
		while(i<j){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
		
	}
	public boolean checkarray(int[] arr){
		int i=0;
		int j=arr.length-1;
		while(i<j){
			if(arr[i]==arr[j]){
				i++;
				j--;
			}else{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		int[] arr={418,381,96,356,411,336,94,433,315,29,140,194,333,489,440,433,469,402,228,228,264,499,318,182,159,159,182,318,499,264,228,228,402,469,433,440,489,333,194,140,29,315,433,94,336,411,356,96,381,418};
		System.out.println(arr.length);
		PalindromeCheck p = new PalindromeCheck();
		System.out.println(p.check("abbcbba"));
		System.out.println("arraycheck "+p.checkarray(arr));
	}
}

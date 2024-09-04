package TwoPointer_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;

public class Maching {
	static public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        TreeMap < Integer, Integer > mp = new TreeMap < Integer, Integer > ();
      // stores the frequency of the elements of A
      for (int i = 0; i < A.size(); i++) {
          int x = A.get(i);
          if (mp.get(x) == null) {
              mp.put(x, 1);
          } else {
              mp.put(x, mp.get(x) + 1);
          }
      }
      ArrayList < Integer > ans = new ArrayList < Integer > ();
      for (int i = 0; i < B.size(); i++) {
          int y = B.get(i);
          // checks if y exists in A
          if (mp.get(y) != null) {
              while (mp.get(y) > 0) {
                  ans.add(y);
                  mp.put(y, mp.get(y) - 1);
              }
          }
      }
      Set < Integer > keys = mp.keySet();
      // append the elements that are not present in B
      for (Integer key: keys) {
          int t = mp.get(key);
          while (t > 0) {
              ans.add(key);
              t--;
          }
      }
      return ans;
  }
	public static void main(String[] args){
		ArrayList<Integer> al1=new ArrayList<Integer>(Arrays.asList(2,4,6,5));
		ArrayList<Integer> al2=new ArrayList<Integer>(Arrays.asList(2,4));
		ArrayList<Integer> ret= solve(al1,al2);
		for(int i=0;i<ret.size();i++){
			System.out.print(ret.get(i));
		}
		
	}
}

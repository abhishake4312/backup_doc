package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {

	public static void main(String[] args){
		
		LinkedHashSet lhs= new LinkedHashSet(); //default size 16 and load factor 0.75
		LinkedHashSet lhs2= new LinkedHashSet(100,(float)0.80);//initial size 100 and LF = 0.8
		LinkedHashSet<Integer> lhs3= new LinkedHashSet<Integer>();//homogenous
		Set lhs4= new LinkedHashSet(); //ref variable is a interface
		
		lhs.add(5);
		lhs.add(3);
		lhs.add(7);
		lhs.add(9);
		lhs.add(2);
		
		System.out.println(lhs);//insertion order preserved in LinkedHashSet
		
		HashSet hs= new HashSet();
		hs.add(5);
		hs.add(3);
		hs.add(7);
		hs.add(9);
		hs.add(2);
		System.out.println(hs); //insertion order not preserved in HashSet
		System.out.println(lhs3.remove(12));
	}
}

package collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args){
		HashSet hs = new HashSet(); // default capacity = 16 , load factor 0.75
		
		HashSet hs2 = new HashSet(20); //initial capacity = 20 , load factor 0.75
		
		HashSet hs3 = new HashSet(30, (float)0.80); //initial cap = 30 , load factor 0.80
		
		HashSet<Integer> hs4= new HashSet<Integer>();
		
		hs.add(20);
		hs.add("abhi");
		hs.add(20.8);
		hs.add(null);
		System.out.println(hs); // insertion order not preserved
		
		hs.add(20);
		System.out.println(hs);// even if we add 20 it is not added again. dup not allowed
		
		hs.remove(20); // here 20 is value no index
		System.out.println(hs);
		
	//	hs.get(2); //not allowed get and set method no index concept. In order to get this you need to loop
		
		//ITERATE
		for(Object o : hs){
			System.out.println(o);
		}
		
		Iterator itr = hs.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		System.out.println(hs);
		hs4.add(40);
		hs4.addAll(hs);
		System.out.println(hs4); //Though hs4 is a homo hashset but it can addAll the hetero one
		
		HashSet<String> hs5 = new HashSet<String>();
		hs5.add("ram");
		
	//	hs4.addAll(hs5); // but we cannot do different homo type in another homo type
		
		//UNION OPERATION IN SET
		
		System.out.println("UNION OPR");
		HashSet<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		
		HashSet<Integer> set2 = new HashSet<Integer>();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(6);
		
		set1.addAll(set2); //This will add set2 elements into set1 and remove dup
		System.out.println(set1);
		
		set1.retainAll(set2); // this will give interection of set2 and new set1
		System.out.println(set1);
		
		set1.containsAll(set2); //this is true if set2 is a subset of set1
		int x=9;
		char b= (char) x;
		System.out.println(b);
	}
}

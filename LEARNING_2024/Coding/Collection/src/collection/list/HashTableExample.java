package collection.list;

import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashTableExample {
	
	public static void main(String[] args){
		
		Hashtable t = new Hashtable(); //default size is 11, load factor 0.75
		Hashtable t2 = new Hashtable(15); // initial cap is 15 now 
		Hashtable t3 = new Hashtable(15,(float) 0.85); // initial cap is 15 now 
		
		Hashtable<Integer,String> ht = new Hashtable<Integer,String>();
		
		ht.put(1, "abhishek");
		ht.put(2, "raj");
		ht.put(3, "john");
	//	ht.put(null, "abhishek"); // null is not allowed as Key or value
	//	ht.put(101, null);        // null is not allowed as Key or value
		System.out.println(ht);
		
		System.out.println("get method "+ ht.get(3));
		ht.remove(3);
		System.out.println("remove method "+ht);
		
		System.out.println("size method "+ht.size());
		System.out.println("isEmpty() method "+ht.isEmpty());
		
		System.out.println("containsKEy method "+ht.containsKey(4));
		System.out.println("containsValue method "+ht.containsValue("raj"));
		
		/// entry methods
		
		Set<Integer> s = ht.keySet();
		System.out.println(s);
		
		//Iterator method for iterating
		Iterator itr = s.iterator();
		System.out.println("Iterator method for Keyset");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		// for each method for iterating
		// if we just do Integer x:s is wrong as s is not defined as Integer
		System.out.println("For each method for keyset");
		for(Integer x:s){
			System.out.println(x);
		}
		
		// FOR METHOD CANNOT BE USED for HASHSET HASHMAP HASHTABLE as there is no index concept
		
		//using values() method to get values in COLLECTION
		Collection<String> value=ht.values();
		Iterator itr2=value.iterator();
		System.out.println("Iterator way to iterate on values Collection");
		while(itr2.hasNext()){
			System.out.println(itr2.next());
		}
		for(String s3 : value){
			System.out.println(s3);
		}
		
		//ENTRY SET METHOD
		
		Set<Entry<Integer,String>> entries = ht.entrySet();
		System.out.println("Iterator method for entrySet");
		Iterator itr3=entries.iterator();
		while(itr3.hasNext()){
		//	System.out.println(itr3.next());
			Map.Entry entry = (Entry) itr3.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		//for each for entryset
		System.out.println("FOR each for entryset");
		for(Object o :entries){
			Map.Entry<Integer,String> entry=(Entry<Integer, String>) o;
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		///MOST USED METHOD FOR ENTRYSET
		System.out.println("Most used entryset method");
		
		//WHY WE CANNOT USE DIRECTLY entries first define Set<Entry<Integer,String>>
		for(Map.Entry<Integer,String> entry: entries){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		for(Map.Entry<Integer,String> entry: ht.entrySet()){
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
		
		
	}

}

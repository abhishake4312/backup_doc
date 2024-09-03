package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args){
		
		Map<Integer, String> map=new HashMap<Integer,String>();
		map.put(1, "abhi");
		map.put(2, "ram");
		map.put(3, "raj");
		map.put(4, "john");
		map.put(null, "ramesh");
		map.put(null, "ram"); //only 1 null in key
	   System.out.println(map);
	   
	   String name = map.get(4);
	   System.out.println(name);
	   
	   map.remove(3);
	   System.out.println(map);
	   
	   System.out.println(map.containsKey(2));
	   
	   System.out.println(map.containsValue("raj"));
	   
	   System.out.println(map.size());
	   
	   Map map2 = new HashMap();
	   map2.putAll(map);
	   System.out.println(map2);
	   
	   
	   // PRINTING KEYSETS AS OBJECT
	   Set<Integer> keys=map.keySet();
	   System.out.println(keys);
	   for(Integer i: keys){
		   System.out.println(i);
	   }
	   
//	   ArrayList keys2=(ArrayList) map2.keySet(); // runtime exception "main" java.lang.ClassCastException: java.util.HashMap$KeySet cannot be cast to java.util.ArrayList
	                                              //	at collection.list.HashMapExample.main(HashMapExample.java:41)
	   System.out.println(keys);
	   
	   Collection<String> c = map.values();// if we use ArrayList c = (ArrayList) map.values it will give exception
	                               // cause object is Parent and ref variable is child 
	                               // Child c = new Parent() not in java 
	   ArrayList<String> al =new ArrayList<String>(c);
	   Collections.sort(al);
	   for(int i=0;i<al.size();i++){
		   System.out.println( "values "+al.get(i));
	   }
	   for(String i: c){
		   System.out.println(i);
	   }
	   
	   
	   
	  
	   System.out.println(c);
	   
	   
	   
	   // ENTRY SET STARTS 
	   
	   System.out.println("ENTRY SET STARTING");
	  
	   
	   
	   
	  
	   
	   Set entrySet=map.entrySet();
	   
	   for(Object o : entrySet){
		   System.out.println("ENTRY WITH SET"+o);
		   
		Entry<Integer, String> e= (Entry<Integer, String>) o;
		   System.out.println(e.getValue());
	   }
	   
	   //ENTRY METHODS ****************
	   
	   for(Entry<Integer,String> e: map.entrySet()){
		   System.out.println(e.getKey());
		   System.out.println(e.getValue());
		   e.setValue("hello");
	   }
	   System.out.println(map);
	}
}

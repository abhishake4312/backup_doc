package collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
	
		// Store heterogenous data
		LinkedList l= new LinkedList();
        
		// Store homo data
		LinkedList<String> l2 = new LinkedList<String>();
		
		// ref as interface
		List<String> l3 = new LinkedList<String>();
		
		//  add(Object o)
		l.add(5.5);
		l.add("abhishek");
		l.add(4);
		l.add(null);
		System.out.println(l);
		
		// add(int index, Object o)
	//	l.add(6,"ram"); // this will give IndexOutBound exception as next memory index is 4
		l.add(4,"ram");
		l.add(5,'A');
		System.out.println(l);
		
		// remove(Object o)
		l.remove((Character)'A');
		System.out.println(l);
		
		//remove(int index)
		l.remove(2);
		System.out.println(l);
		
		//retireve value get(int index)
		System.out.println(l.get(3));
		
		// replace value set(int index , Object o)
		l.set(3,"sita");
		System.out.println(l);
		
		
		//READ ALL DATA
		
		System.out.println("Iterate using for loop");
		for(int i=0;i<l.size();i++){
			System.out.print(l.get(i)+" ");
		}
		System.out.println();
		System.out.println("Iterate using foreach loop");
		for(Object o: l){
			System.out.print(o+" ");
		}
		System.out.println();
		System.out.println("Iterate using iterator");
		Iterator itr = l.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		
		
		// addAll and removeAll generally for homogenous data if we define LinkedList
		LinkedList<String> s2=new LinkedList<String>();
		s2.add("Sumit");
		s2.addAll(l);
		System.out.println(s2);
		
		LinkedList<Integer> s3= new LinkedList<Integer>();
		s3.add(500);
	//	s3.addAll(s2);// this gives error as s2 is definded as String
		s3.addAll(l);//this doesnot give error as l is undefinded
		System.out.println(s3);
		System.out.println(s3.get(2));
		
	}

}

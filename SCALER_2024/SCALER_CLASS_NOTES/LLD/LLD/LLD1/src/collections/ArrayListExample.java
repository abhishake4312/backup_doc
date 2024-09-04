package collections;

import java.util.*;

public class ArrayListExample {

	public static void main(String[] args) {
	
		// Heterogenous object can be stored
		ArrayList al=new ArrayList();
		
		ArrayList<Integer> alcomparision=new ArrayList<Integer>(3);

		Stack s= new Stack();
		alcomparision.get(0);
		// using interface as ref variable
	//	List<String> al3= new ArrayList<String>();
		
		// all elements are stored in continous memory location
//		alcomparision.add(5); // add(Object o)
//		System.out.println(alcomparision.get(1));
//		alcomparision.add(2);
//		alcomparision.add(5);
//		if(alcomparision.get(0)==alcomparision.get(2)){
//			System.out.println("checking == comparision");
//		}
//		if(alcomparision.get(0).equals(alcomparision.get(2))){
//			System.out.println("checking equals comparision");
//		}
//		al.add("ram");
//		al.add(5.8);
//		al.add('A');
//		al.add(true);
//	//	al.add(7,"abhishek");// exception as array store value in continous location so next location is 5
//		al.add(5,"abhishek");  // add(int index, Object o)
//		
//		System.out.println(al);
//		
//		System.out.println(al.size());
//		System.out.println(al.isEmpty());
//		
//		// Remove element 
//		System.out.println(al.remove((Integer)5)); // treat 5 as Object  remove(Object o)
//		//System.out.println(al.remove(5)); // treat 5 as index          remove(int index)
//		
//		System.out.println(al);
//		
//		//Retrieve element  get(int index)
//		System.out.println(al.get(2)); 
//		
//		// Replace element
//		System.out.println(al.set(4,"sumit"));
//		
//		System.out.println(al);
//		
//		//search element
//        System.out.println(al.contains(5.8));
//        
//        //insert element at last position
//        al.add(al.size(),5);
//        
//        System.out.println(al);
//        al.re
//        
//        
//        //READ DATA FROM ARRAYLIST using iterator
//        
//        Iterator itr= al.iterator();
//        while(itr.hasNext()){
//        	System.out.println(itr.next());
//        }
//        
//        //ADD all method
//        System.out.println("values in first list "+al);
//        ArrayList al2 = new ArrayList();
//        al2.add("raj");
//        al2.remove();
//        System.out.println("values in second list "+al2);
//        al2.addAll(al);
//        System.out.println("values in second list after addAll"+al2+" "+al2.get(2));
//        
//        
//        //Sorting  use Collections.sort(al) al must be homogenous
//   //     Collections.sort(al);
//        
//		//Homogenous object can be stored
//        
//        String[] arr={"abhi","raj"};
//        ArrayList<String> al3 =new ArrayList<String>( Arrays.asList(arr));
//
//	
//        System.out.println("values in array"+al3);
//	
      //  Stack s new Stack();
	}

}

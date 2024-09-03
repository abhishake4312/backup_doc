package collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args){
		
		// METHODS INSIDE QUEUE(I)
		// add(Object o)
		// offer(Object o)
		// Object element()
		// Object peek()
		// Object remove()
		// Object poll()
		PriorityQueue pq= new PriorityQueue(); // 1st impl class of Queue only store homo data
		
		pq.add(10);
		pq.offer(20);
	//	pq.offer("abhi"); // It will give exception as PriorityQueue holds homogenous data
		pq.offer(40);
		pq.add(80);
		
		System.out.println(pq);
		
		System.out.println("peek()  "+pq.peek());
		System.out.println("element()   "+pq.element());
		
		System.out.println("REMOVING ELEMENTS");
		while(!pq.isEmpty()){
			System.out.print(pq.poll()+" ");
		}
		System.out.println();
		System.out.println("Checking functions when Q is empty");
		System.out.println(pq.peek()); // return false as Q is empty
	//	System.out.println(pq.element());//throws exception as Q is empty
		System.out.println(pq.poll());//return false as Q is empty
	//	System.out.println(pq.remove());//return false as Q is empty
		
		//ITERATOR OVER QUEUE
		
		System.out.println(pq);
		pq.add(10);
		pq.offer(20);
		pq.offer(40);
		pq.add(80);
		for(Object o : pq){
			System.out.println(o);
		}
		
		
		//LINKEDLIST IMPL
		System.out.println("LINKEDLIST IMPL");
		Queue lq = new LinkedList(); 
		lq.add("abhishek");
		lq.offer(20);
		lq.offer(20.5);
	 
		System.out.println(lq.peek());
		System.out.println(lq.element());
		
		Deque q =new LinkedList();
	//	q.add
		
	}
}

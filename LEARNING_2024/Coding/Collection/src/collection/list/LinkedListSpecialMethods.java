package collection.list;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListSpecialMethods {

	public static void main(String[] args) {
		
		// QUEUE using Linkedlist
		
		LinkedList<String> queue = new LinkedList<String>();
		System.out.println("QUEUE IMPLEMENTATION");
		for(int i=0;i<5;i++){
			System.out.println(i+"th element insertion");
			queue.addLast("element"+i);
		}
		
		//QUEUE FIFO
		for(String s : queue){
			System.out.println(s);
		}
		
		//Stack using LinkedList
		System.out.println("STACK IMPLEMENTATION");
		LinkedList<String> stack = new LinkedList<String>();
		for(int i=0;i<5;i++){
			System.out.println(i+"th element insertion");
			stack.addFirst("element"+i);
		}
		
		//STACK FILO 
		for(String s : stack){
			System.out.println(s);
		}
		

	}

}

package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintInReverse {
	Node head;
	 Node tail;
	 class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	 void printReverse(Node head){
		
		if(head!=null){
			printReverse(head.next);
			System.out.print(head.data+" ");
		}
	}
	 void insertedInBegining(int newdata) {
	        Node mynode = new Node(newdata);
	        mynode.next = head;
	        head = mynode;
	    }
	 void print(Node head){
		 Node tmp=head;
		 while(tmp!=null){
			 System.out.print(tmp.data+" ");
			 tmp=tmp.next;
		 }
	 }
	 void insertedInEnd(int val){
		 Node newnode=new Node(val);
		
		 if(head==null){
			 head=newnode;
			 tail=head;
		 }else{
			 tail.next=newnode;
			 tail=tail.next;
		 }
	 }
	 
	  public int lPalin(Node A) {

	        ArrayList<Integer> al =new ArrayList<Integer>();
	        Node tmp=A;
	         while(tmp!=null){
	             al.add(tmp.data);
	             tmp=tmp.next;
	         }
	         System.out.println("arraylist is "+al);
	     return checkPalindrome(al);
	    }
	    int checkPalindrome(ArrayList<Integer> al){
	        int i=0;
	        int n=al.size();
	        int j=n-1;
	        System.out.println(al);
	        while(i<j){
	        	System.out.println("outside");
	        	System.out.println("i "+i+" ="+al.get(i));
            	System.out.println("j "+j+" ="+al.get(j));
            	int x=al.get(i);
            	int y=al.get(j);
	            if(al.get(i)==al.get(j)){
	            	System.out.println("enters if");
	            	System.out.println("i "+i+" ="+al.get(i));
	            	System.out.println("j "+j+" ="+al.get(j));
	                i=i+1;
	                j=j-1;
	            }else{
	            	System.out.println("enters else");
	            	System.out.println("i "+i+" ="+al.get(i));
	            	System.out.println("j "+j+" ="+al.get(j));
	                return 0;
	            }
	        }
	        return 1;
	    }

	public static void main(String[] args){
		
		int[] arr={418,381,96,356,411,336,94,433,315,29,140,194,333,489,440,433,469,402,228,228,264,499,318,182,159,159,182,318,499,264,228,228,402,469,433,440,489,333,194,140,29,315,433,94,336,411,356,96,381,418};
		
		int n=arr.length;
		System.out.println("Original value ");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("Populating link list in begining");
		PrintInReverse l1=new PrintInReverse();
		for(int i=0;i<n;i++){
			l1.insertedInBegining(arr[i]);
		}
		System.out.println("Printing link list");
		l1.print(l1.head);
		
		System.out.println();
		System.out.println("Populating link list in end");
		PrintInReverse l2=new PrintInReverse();
		for(int i=0;i<n;i++){
			l2.insertedInEnd(arr[i]);
		}
		System.out.println("Printing link list");
		l2.print(l2.head);
		System.out.println();
		System.out.println("printing in reverse");
		l2.printReverse(l2.head);
		
		System.out.println();
		System.out.println("Printing link list");
		l2.print(l2.head);
		System.out.println();
		System.out.println("checking palindrome");
		System.out.println(l2.lPalin(l2.head));
		
		ArrayList<Integer> al2=new ArrayList<Integer>();
		al2.add(100);
		al2.add(200);
		al2.add(100);
		if(al2.get(0)==al2.get(2)){
			System.out.println("==checks");
		}
		
	}
}

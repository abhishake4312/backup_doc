package LinkedList;

import java.util.HashMap;

public class LRU_doublelinkedlist {
	    int memcapacity=0;
	    class Node{
	        int datakey;
	        int datavalue;
	        Node prev;
	        Node next;
	        Node(int data1,int data2){
	            this.datakey=data1;
	            this.datavalue=data2;
	            this.prev=null;
	            this.next=null;
	        }
	    }
	    Node head;
	    Node tail;
	    HashMap<Integer,Node> hm;

	    public LRU_doublelinkedlist(int capacity) {
	        this.memcapacity=capacity;
	        this.hm=new HashMap<Integer,Node>();
	        this.head=null;
	        this.tail=null;
	    }
	    
	    public int get(int key) {
	    	System.out.println("getting "+key);
	    	System.out.println(" head"+head.datakey);
	        if(hm.containsKey(key)){
	             Node alreadypresent= hm.get(key);
	            if(alreadypresent.prev==null && alreadypresent.next==null){
	                return  alreadypresent.datavalue;
	            }
	            else if(alreadypresent.next==null){
	                return  alreadypresent.datavalue;
	            }else if(alreadypresent.prev==null){
	                    head=head.next;
	                    head.prev=null;
	                    tail.next=alreadypresent;
	                    alreadypresent.prev=tail;
	                    alreadypresent.next=null;
	                    tail=tail.next;
	                 return  alreadypresent.datavalue;
	            }else{
	                alreadypresent.prev.next=alreadypresent.next;
	                alreadypresent.next.prev=alreadypresent.prev;
	                 tail.next=alreadypresent;
	                    alreadypresent.prev=tail;
	                    alreadypresent.next=null;
	                    tail=tail.next;
	                    return  alreadypresent.datavalue;
	            }     
	        }else{
	            return -1;
	        }
	    }
	    
	    public void set(int key, int value) {
	    	System.out.println("setting "+ key);
	    	if(head!=null){
	    	System.out.println(" head"+head.datakey);
	    	}else{
	    		System.out.println("head  null");
	    	}
	         if(hm.containsKey(key)){
	             Node alreadypresent= hm.get(key);
	            if(alreadypresent.prev==null && alreadypresent.next==null){
	                  alreadypresent.datavalue=value;
	            }
	            else if(alreadypresent.next==null){
	                alreadypresent.datavalue=value;
	            }else if(alreadypresent.prev==null){
	                    head=head.next;
	                    head.prev=null;
	                    tail.next=alreadypresent;
	                    alreadypresent.prev=tail;
	                    alreadypresent.next=null;
	                    tail=tail.next;
	                 alreadypresent.datavalue=value;
	            }else{
	                alreadypresent.prev.next=alreadypresent.next;
	                alreadypresent.next.prev=alreadypresent.prev;
	                 tail.next=alreadypresent;
	                    alreadypresent.prev=tail;
	                    alreadypresent.next=null;
	                    tail=tail.next;
	                    alreadypresent.datavalue=value;
	            }     
	        }else{
	            Node newnode=new Node(key,value);
	            if(hm.size()>=memcapacity){
	                int removekey=head.datakey;
	                hm.remove(removekey);
	                if(head==tail){
	                    head=newnode;
	                    tail=head;
	                }else{
	                    head=head.next;
	                    head.prev=null;
	                    tail.next=newnode;
	                    newnode.prev=tail;
	                    tail=tail.next;
	                }
	                
	                hm.put(key,newnode);
	            }else if(hm.size()<memcapacity){
	                if(head==null){
	                    head=newnode;
	                    tail=head;
	                }else{
	                    tail.next=newnode;
	                    newnode.prev=tail;
	                    tail=tail.next;
	                }
	                hm.put(key,newnode);
	            }
	        }
        }
	    public static void main(String args[]){
	    	LRU_doublelinkedlist l= new LRU_doublelinkedlist(4);
//	    	S 3 13 G 5 S 8 9 G 8 G 3 G 8 S 1 11 G 7 S 10 14 G 13 
//	    	S 2 13 S 9 5 S 7 11 S 14 2 S 7 2 G 12 G 14 G 11 S 11 8 
//	    	G 1 G 8 S 1 2 S 9 7 G 7 S 1 14 S 2 12 S 9 5 S 1 1 G 1 G 14 G 4 S 13 11

	    	l.set(3,13);
	    	System.out.println(l.get(5));
	    	l.set(8, 9);
	    	System.out.println(l.get(8));
	    	System.out.println(l.get(3));
	    	System.out.println(l.get(8));
	    	l.set(1, 11);
	    	System.out.println(l.get(7));
	    	l.set(10, 14);
	    	System.out.println(l.get(13));
	    	l.set(2, 13);
	    	l.set(9, 5);
	    	l.set(7, 11);
	    	l.set(14, 2);
	    	l.set(7, 2);
	    	System.out.println(l.get(12));
	    	System.out.println(l.get(14));
	    	System.out.println(l.get(11));
	    	l.set(11, 8);
	    	System.out.println(l.get(1));
	    	System.out.println(l.get(8));
	    	l.set(1, 2);
	    	l.set(9, 7);
	    	System.out.println(l.get(7));
	    	l.set(1, 14);
	    	l.set(2, 12);
	    	l.set(9, 5);
	    	l.set(1, 1);
	    	System.out.println(l.get(1));
	    	System.out.println(l.get(14));
	    	System.out.println(l.get(4));
	    	l.set(13, 11);
	    }
}

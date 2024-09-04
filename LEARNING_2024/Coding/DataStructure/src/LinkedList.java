// Java program to reverse alternate k nodes in a linked list
 
class LinkedList {
 
    static Node head;
 
    class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
//    /* Reverses alternate k nodes and
//     returns the pointer to the new head node */
//    Node kAltReverse(Node node, int k) {
//        Node current = node;
//        Node next = null, prev = null;
//        int count = 0;
// 
//        /*1) reverse first k nodes of the linked list */
//        while (current != null && count < k) {
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//            count++;
//        }
// 
//        /* 2) Now head points to the kth node.  So change next
//         of head to (k+1)th node*/
//        if (node != null) {
//            node.next = current;
//        }
// 
//        /* 3) We do not want to reverse next k nodes. So move the current
//         pointer to skip next k nodes */
//        count = 0;
//        while (count < k - 1 && current != null) {
//            current = current.next;
//            count++;
//        }
// 
//        /* 4) Recursively call for the list starting from current->next.
//         And make rest of the list as next of first node */
//        if (current != null) {
//            current.next = kAltReverse(current.next, k);
//        }
// 
//        /* 5) prev is new head of the input list */
//        return prev;
//    }
 
    
    Node alternateReverse(Node head , int k ) {
    	
    	if(head == null ) {
    		return head;
    	}
    	
    	int count =0;
    	Node tmp=head;
    	while(tmp!=null) {
    		count++;
    		tmp=tmp.next;
    	}
    	
    	if(count<=k) {
    		return reverse(head);
    	}
    	else if(count> 2*k) {
    		Node tmp2=head;
    		Node prev = null;
    		for( int i=0;i<2*k;i++) {
    			prev=tmp2;
    			tmp2=tmp2.next;
    		}
    		prev.next=alternateReverse(tmp2,k);
    	}
    	Node prev2=null;
    	Node tmp3=head;
    	Node tmp4=head;
    	for(int i=0;i<k;i++) {
    		prev2=tmp3;
    		tmp3=tmp3.next;
    	}
    	prev2.next=null;
    	Node revHead=reverse(tmp4);
    	head.next=tmp3;
    	return revHead;
    }
    
    Node reverse(Node head) {
    	
    	Node newNode;
    	Node tmp=null;
    	while(head !=null)
    	{
    		newNode =head.next;
    		head.next=tmp;
    		tmp=head;
    		head=newNode;
    	}
    	return tmp;
    }
    
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    void push(int newdata) {
        Node mynode = new Node(newdata);
        mynode.next = head;
        head = mynode;
    }
 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
 
        // Creating the linkedlist
        for (int i = 21; i > 0; i--) {
            list.push(i);
        }
        System.out.println("Given Linked List :");
        list.printList(head);
        head = list.alternateReverse(head, 4);
        System.out.println("");
        System.out.println("Modified Linked List :");
        list.printList(head);
 
    }
}
 
// This code has been contributed by Mayank Jaiswal
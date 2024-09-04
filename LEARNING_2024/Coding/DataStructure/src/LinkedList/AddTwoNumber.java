package LinkedList;

import LinkedList.PrintInReverse.Node;

public class AddTwoNumber {
	ListNode head;
	ListNode tail;
	 class ListNode{
		int val;
		ListNode next;
		
		ListNode(int data){
			this.val=data;
			this.next=null;
		}
	}
	  public  ListNode addTwoNumbers(ListNode A, ListNode B) {
	        if(A==null){
	            return B;
	        }
	        if(B==null){
	            return A;
	        }

	        ListNode p1=A;
	        ListNode p2=B;
	        ListNode curr=A;
	        int carry=0;
	        while(p1!=null && p2!=null){
	            int sum= p1.val+p2.val+carry;
	            int valnew=sum%10;
	            System.out.println("sum "+sum);
	            curr.val=valnew;
	            System.out.println("currVal "+curr.val);
	            carry=sum/10;
	            System.out.println("checking A"+A.val);
	            p1=p1.next;
	            p2=p2.next;
	            if(p1==null && p2==null){
	                if(carry!=0){
	                    ListNode last=new ListNode(carry);
	                    curr.next=last;
	                  
	                }
	                System.out.println("finally return here");
	                ListNode ret=A;
	                while(ret!=null){
	                	System.out.println(ret.val);
	                	ret=ret.next;
	                }
	                  return A;
	            }
	            if(p1==null){
	                curr=p2;
	            }else{
	                curr=p1;
	            }        

	        }
//	        System.out.println("come here return here");
//	        while(p2!=null){
//	            int sum= p2.val+carry;
//	            int valnew=sum%10;
//	            carry=sum/10;
//	            curr.val=valnew;
//	            
//	            p2=p2.next;
//	             if(p2==null){
//	                if(carry!=0){
//	                    ListNode last=new ListNode(carry);
//	                    curr.next=last;
//	                    
//	                }
//	                return A;
//	            }
//	            curr=p2;
//	        }
//	            while(p1!=null){
//	            int sum= p1.val+carry;
//	            int valnew=sum%10;
//	            carry=sum/10;
//	            curr.val=valnew;
//	            
//	            p1=p1.next;
//	             if(p1==null){
//	                if(carry!=0){
//	                    ListNode last=new ListNode(carry);
//	                    curr.next=last;
//	                   
//	                }
//	                 return A;
//	            }
//	            curr=p1;
//	        }
	        return A;
	    }
	  void insertedInEnd(int val){
		  ListNode newnode=new ListNode(val);
			
			 if(head==null){
				 head=newnode;
				 tail=head;
			 }else{
				 tail.next=newnode;
				 tail=tail.next;
			 }
		 }
	  public static void main(String[] args){
		  AddTwoNumber l1=new AddTwoNumber();
		  int[] list1={3,4};
		  int[] list2={5,2};
		  
			for(int i=0;i<list1.length;i++){
				l1.insertedInEnd(list1[i]);
			}
			AddTwoNumber l2=new AddTwoNumber();
			for(int i=0;i<list2.length;i++){
				l2.insertedInEnd(list2[i]);
			}
		ListNode l3=l1.addTwoNumbers(l1.head,l2.head);
		
		while(l3!=null){
			System.out.print(l3.val+" ");
			l3=l3.next;
		}
	  }
}

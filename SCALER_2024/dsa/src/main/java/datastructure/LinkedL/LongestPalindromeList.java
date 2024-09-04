package datastructure.LinkedL;



public class LongestPalindromeList {
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
	  public  int solve(ListNode A) {
	        ListNode p1=A;
	        // if(p1.next==null){
	        //     return 1;
	        // }
	     //   p1=p1.next;
	        int maxsize=1;
	        while(p1!=null && p1.next!=null){
	             
	             int size= checkPalindrome(A,p1,p1)+1;
	             System.out.println("size"+size);
	             maxsize=Math.max(size,maxsize);
	              if(p1.val==p1.next.val){
	                 int size2=checkPalindrome(A,p1,p1.next);
	                 maxsize=Math.max(size2,maxsize);
	              }
	           p1=p1.next;
	        }
	        return maxsize;

	    }
	  ListNode reversetill(ListNode head,ListNode till){
		  ListNode newnode=null;
          ListNode tmp=null;
          while(head!=null && newnode !=till){
              newnode=head.next;
              head.next=tmp;
              tmp=head;
              head=newnode;
          }
          return tmp;
	  }
	    int checkPalindrome(ListNode head,ListNode curr,ListNode next){
	        
	    	boolean odd=false;
	        if(curr==next){
	        	odd=true;
	        }
	            ListNode stoppoint=curr.next;
	            ListNode tmp=reversetill(head,stoppoint);
	            head.next=stoppoint;
	            ListNode pointA=tmp;
	            if(odd){
	                pointA=tmp.next;
	            }
	           
	            ListNode pointB=stoppoint;
	            int count=0;
	            while(pointB!=null && pointA!=stoppoint && pointA.val==pointB.val){
	                count=count+2;
	                pointB=pointB.next;
	                pointA=pointA.next;
	            }
	            //reverse again
	            reversetill(tmp,stoppoint);
	            tmp.next=stoppoint;
	            return  count;
	            
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
			  LongestPalindromeList l1=new LongestPalindromeList();
			  int[] arr={2,1,2,2};
				for(int i=0;i<arr.length;i++){
					l1.insertedInEnd(arr[i]);
				}
			
			System.out.println(l1.solve(l1.head));
		  }
}

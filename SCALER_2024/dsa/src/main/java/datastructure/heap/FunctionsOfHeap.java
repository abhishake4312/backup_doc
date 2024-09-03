package datastructure.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionsOfHeap {

	static void buildMinHeap(ArrayList<Integer> al){
		int n=al.size();
		
		for(int i= (n-2)/2;i>=0;i--){
			heapify(al,i);
		}
	}
	static void heapify(ArrayList<Integer> al,int index){
		int pindex=index;
		int leftcindex=2*pindex+1;
		int rightcindex=2*pindex+2;
		int n=al.size();
		
		while((2*pindex+1)<n){
		    leftcindex=2*pindex+1;
		    rightcindex=2*pindex+2;
		    int rightcval= (rightcindex<n)?al.get(rightcindex):Integer.MAX_VALUE;
			int minval= Math.min(al.get(pindex), Math.min(al.get(leftcindex),rightcval));
			if(minval==al.get(pindex)){
				break;
			}else if(minval==al.get(leftcindex)){
				int tmp=al.get(pindex);
				al.set(pindex, al.get(leftcindex));
				al.set(leftcindex, tmp);
				pindex=leftcindex;
			}else if(rightcindex<n && minval==al.get(rightcindex)){
				int tmp=al.get(pindex);
				al.set(pindex,al.get(rightcindex));
				al.set(rightcindex,tmp);
				pindex=rightcindex;
			}	
		}
	}
	static void insert(ArrayList<Integer> al,int x){
		al.add(x);
		int curr=al.size()-1;
		
		while(curr>0){
			int pindex=(curr-1)/2;
			if(al.get(pindex)>al.get(curr)){
				int tmp=al.get(pindex);
				al.set(pindex,al.get(curr));
				al.set(curr,tmp);
				curr=pindex;
			}else{
				break;
			}
		}
	}
	static int extractMin(ArrayList<Integer> al){
		int last=al.size()-1;
		int first=0;
		int tmp=al.get(first);
		al.set(first,al.get(last));
		al.set(last,tmp);
		int ret=al.get(last);
		al.remove(last);
		heapify(al,first);
		return ret;
	}
	public static void main(String[] args){
		int[] a={8,9,4,5,7,22};
	    ArrayList<Integer> al = new ArrayList<Integer>();
	    System.out.println("BEFORE");
	    for(int i=0;i<a.length;i++){
	    	al.add(a[i]);
	    	System.out.print(al.get(i)+" ");
	    }
	    buildMinHeap(al);
	    System.out.println();
	    System.out.println("AFTER");
	    for(int i=0;i<al.size();i++){
	    	System.out.print(al.get(i)+" ");
	    }
	    
	    System.out.println("Inserting new element");
	    insert(al,3);
	    System.out.println("AFTER INSETING 3");
	    for(int i=0;i<al.size();i++){
	    	System.out.print(al.get(i)+" ");
	    }
	    System.out.println();
	    System.out.println("Extract and remove min ");
	    int min=extractMin(al);
	    System.out.println("AFTER extracting min "+min);
	    for(int i=0;i<al.size();i++){
	    	System.out.print(al.get(i)+" ");
	    }
	    
	}
}

package datastructure;

import java.util.ArrayList;


public class PrimeCount {

	public static  ArrayList<Integer> prime(int st, int end) {
	    
	    ArrayList<Integer> al=new ArrayList<Integer>();
	    for(int i=st;i<=end;i++){
	        if(factor(i)==2){
	            al.add(i);
	        }
	    }
	    return al;
	}
	static int  factor(int num ){
	    int count=0;
	    for(int i=1;i<=Math.sqrt(num);i++){
	        if(num%i==0){
	            count=count+2;
	        }
	        if(i*i==num){
	            count--;
	        }
	    }
	    return count;
	}
	public static void main(String[] args){
		int s=1;
		int e=100;
		ArrayList<Integer> al =prime(s,e);
		for(int i=0;i<al.size();i++){
			System.out.println(al.get(i));
		}
		
	}
}

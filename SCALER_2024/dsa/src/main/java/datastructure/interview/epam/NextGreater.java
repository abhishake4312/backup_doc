package datastructure.interview.epam;

import java.util.Stack;

public class NextGreater {
	public static void main(String[] args){
		int[] arr= {5,4,3,2,99,1,100};
		int n=arr.length;
		int[] output=new int[n];
		Stack<Integer> s=new Stack<Integer>();
		for(int i=n-1;i>=0;i--){
			if(s.isEmpty()){
				output[i]=-1;
				s.push(arr[i]);
			}else{
			   int peek=s.peek();
			   
			   if(peek>arr[i]){
				   output[i]=peek;
				   s.push(arr[i]);
			   }else{
				   while(!s.isEmpty() && s.peek()<=arr[i]){
					   s.pop();   
				   }
				   if(s.isEmpty()){
					   output[i]=-1;
				   }else{
				   output[i]=s.peek();
				   }
				   s.push(arr[i]);
			   }
			}
		}
		for(int i=0;i<n;i++){
			System.out.println(output[i]);
		}
		
	}
}

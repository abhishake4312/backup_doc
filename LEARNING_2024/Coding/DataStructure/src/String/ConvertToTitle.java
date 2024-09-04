package String;

import java.util.ArrayList;

public class ConvertToTitle {
	  public static String convertToTitle(int A) {
	        
	        StringBuilder sb=new StringBuilder();
	        ArrayList<Integer> al = new ArrayList<Integer>();
	        while(A>0){
	            int val= A%26;
	            System.out.println(val);
	            if(val==0){
	                al.add(90);
	            }else{
	            al.add(65+val-1);
	            }
	            A=A/26;
	        }
	        String s= "";
	        for(int i=al.size()-1;i>=0;i--){
	            int a=al.get(i);
	            char c=(char)a;
	            s=s+c;
	        }
	        
	        return s;

	    }
	  public static void main(String[] args){
		  System.out.println(convertToTitle(943566));
	  }
}


public class Kth_symbol {


public static int solve(int A, int B) {
    String s="0";
   for(int i=0;i<A-1;i++){
	   System.out.println(s);
       int val= Integer.parseInt(s);
       String s2="";
       for(int j=0;j<s.length();j++){
           if((val &(1<<j))==0){
        	   s2="1"+s2;
           }else{
        	   s2="0"+s2;
           }
       }
      
       System.out.println("s2 "+s2);
       s=s+s2;
       
   }
   char c = s.charAt(B);
   String sx=c+"";
   int x= Integer.parseInt(sx);
   return x;
}
public static void main(String[] args){
	System.out.println(solve(4,3));
	
}

}
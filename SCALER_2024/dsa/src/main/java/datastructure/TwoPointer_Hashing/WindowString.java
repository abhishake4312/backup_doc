package datastructure.TwoPointer_Hashing;

import java.util.HashMap;
import java.util.Map;

public class WindowString {


    public static String minWindow(String A, String B) {
        int n=A.length();
        int m=B.length();
        HashMap<Character,Integer> hmA=new  HashMap<Character,Integer>();
        HashMap<Character,Integer> hmB=new  HashMap<Character,Integer>();
        for(int i=0;i<m;i++){
             Character key=B.charAt(i);
             if(hmB.containsKey(key)){
                 int val=hmB.get(key);
                 hmB.put(key,val+1);
             }else{
                 hmB.put(key,1);
             }
        }
        System.out.println(hmB);
        int i=0;
        int j=0;
        int minSize=Integer.MAX_VALUE;
        int start=-1;
        int end=-1;
        while(i<n && j<n){
        	System.out.println("hmA "+hmA+" hmB "+hmB);
            boolean containsB= checkBinA(hmA,hmB);
            System.out.println("containsB "+containsB);
            if(!containsB){
                    Character key=A.charAt(j);
                    if(hmA.containsKey(key)){
                        int val=hmA.get(key);
                        hmA.put(key,val+1);
                    }else{
                        hmA.put(key,1);
                    }
                    j++;
            }else{
                  int size=j-i;
                  if(size<minSize){
                      start=i;
                      end=j;
                      minSize=size;
                  }
                  Character out=A.charAt(i);
                  int val=hmA.get(out);
                  if(val==1){
                      hmA.remove(out);
                  }else{
                      hmA.put(out,val-1);
                  }
                  i++;
            }
        }
        System.out.println("i j"+ i+" "+j);
        boolean containsB= checkBinA(hmA,hmB);
        if(containsB){
        	System.out.println("inside i "+i +" j "+j);
        for(int k=i;k<n;k++){
            Character c = A.charAt(k);
            if(hmB.containsKey(c)){
                int size=j-k;
                 if(size<minSize){
                      start=k;
                      end=j;
                      minSize=size;
                  }
                  break;
            }
        }
        }
        
       

        if(start==-1){
            return "";
        }
        String ret= A.substring(start,end);
        return ret;
    }
    static  boolean  checkBinA(HashMap<Character,Integer> hmA,HashMap<Character,Integer> hmB){

        for(Map.Entry<Character,Integer> e: hmB.entrySet()){
            Character key=e.getKey();
            int val=e.getValue();
            if(!hmA.containsKey(key) || hmA.get(key)<val){
                return false;
            }
        }
        return true;
    }
  public static void main(String[] args){
	  String A="ADOBECODEBANC";
	  String B="ABC";
	  String ret=minWindow(A,B);
	  System.out.println(ret);
  }
}

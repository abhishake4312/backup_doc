package tries;

import java.util.HashSet;

public class FrequencyCount {
	 static class Trie{
	        Trie[] child;
	        int freq;
	        Trie(){
	            child=new Trie[26];
	            freq=0;
	        }
	    }
	    //Function to find most frequent word in an array of strings.
	    public static String mostFrequentWord(String arr[],int n)
	    {
	        Trie root=new Trie();;
	        // code here
	        for(int i=0;i<n;i++){
	            insert(root,arr[i]);
	        }
	        int maxfreq=0;
	        String maxfreqstring="";
	        HashSet<String> hs=new HashSet<String>();
	        for(int i=0;i<n;i++){
	            
	           if(!hs.contains(arr[i])){
		            int countfreq=count(root,arr[i]);
		            if(countfreq>=maxfreq){
		                maxfreq=countfreq;
		                maxfreqstring=arr[i];
		            }
		            hs.add(arr[i]);
	           }
	          
	        }
	        for(int i=0;i<n;i++){
	        	System.out.println("word "+arr[i]+" freq"+count(root,arr[i]));
	        }
	        return maxfreqstring;
	    }
	     static void insert(Trie root,String a){
	        int n=a.length();
	        for(int i=0;i<n;i++){
	            int index=a.charAt(i)-'a';
	            if(root.child[index]==null){
	                root.child[index]=new Trie();
	            }
	            root=root.child[index];
	        }
	        root.freq++;
	    }
	        static int count(Trie root,String a){
	        int n=a.length();
	        for(int i=0;i<n;i++){
	            int index=a.charAt(i)-'a';
	            
	            root=root.child[index];
	        }
	       return  root.freq;
	    }
	    public static void main(String[] args){
	    	String[] arr= {"abhi","ram","abhi","suraj","raj","ram"};
	    	String mostfrequent= mostFrequentWord(arr,arr.length);
	    	
	    }
}

package datastructure.backtrack;

import java.util.ArrayList;

public class DuplicatePermutation {

	    public static int[][] permute(int[] A) {
	        int[] freq=new int[11];
	        int n=A.length;
	        for(int i=0;i<n;i++){
	            freq[A[i]]= freq[A[i]]+1;
	        }
	        int[] ans=new int[n];
	        int level=0;
	        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
	        createpermute(A,ans,n,freq,level,ret);
	        int[][] retarray=new int[ret.size()][n];
	        for(int i=0;i<ret.size();i++){
	            for(int j=0;j<n;j++){
	                retarray[i][j]=(ret.get(i)).get(j);
	            }
	        }
	        return retarray;
	        
	    }
	    static void createpermute(int[] A,int[] ans,int n,int[] freq,int level,ArrayList<ArrayList<Integer>> ret){
	        if(level==n){
	            ArrayList<Integer> al = new ArrayList<Integer>();
	            for(int i=0;i<n;i++){
	                al.add(ans[i]);
	               
	            }
	             ret.add(al);
	            return;
	        }
	        for(int i=0;i<11;i++){
	            if(freq[i]>1){
	                freq[i]--;
	                ans[level]=i;
	                createpermute(A,ans,n,freq,level+1,ret);
	                freq[i]++;
	            }
	        }
	    }
	    public static void main(String[] args){
	    	int[] arr={1,2,2};
	    	permute(arr);
	    }
	}



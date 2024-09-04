package datastructure.backtrack;

import java.util.ArrayList;

public class DistinctScaler {
   
    	   
        public int[][] permute(int[] A) {
            int n=A.length;
           
         
            int[] ans=new int[n];
        
            int itr=0;
            int[] visited=new int[n];
            ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
            findPermutation(A,ans,n,itr,visited,ret);
            int[][] retarr=new int[ret.size()][n];
            for(int i=0;i<ret.size();i++){
                for(int j=0;j<n;j++){
                    retarr[i][j]=(ret.get(i)).get(j);
                }
            }
            return retarr;
        }


        void findPermutation(int[] A,int[] ans ,int n,int itr,int[] visited, ArrayList<ArrayList<Integer>> ret ){
            if(itr==n){
                ArrayList<Integer> al = new ArrayList<Integer>();
                for(int i=0;i<n;i++){
                    al.add(ans[i]);
                }
                ret.add(al);
                return;
            }
            for(int i=0;i<n;i++){
                if(visited[i]==0){
                    visited[i]=1;
                    ans[itr]=A[i];
                    findPermutation(A,ans,n,itr+1,visited,ret);
                    visited[i]=0;
                }
            }
        }
    }



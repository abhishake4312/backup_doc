package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class PrimsAlgoMST {
    static class Pair{
        int nbrnode;
        int weight;
        Pair(int nbrnode,int weight){
            this.nbrnode=nbrnode;
            this.weight=weight;
        }
    }
    public static int solve(int A, int[][] B) {
        ArrayList<ArrayList<Pair>> graph=new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<=A;i++){
            graph.add(new ArrayList<Pair>());
        }
        int m=B.length;
        if(m==0){
            return 0;
        }
        for(int i=0;i<m;i++){
            int node1=B[i][0];
            int node2=B[i][1];
            int weight=B[i][2];
            graph.get(node1).add(new Pair(node2,weight));
            graph.get(node2).add(new Pair(node1,weight));
        }
     
        PriorityQueue<Pair> minheap=new PriorityQueue<Pair>(m,new Comparator<Pair>(){
          public  int compare(Pair a,Pair b){
                return a.weight-b.weight;
            }
        });
        // PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(a.size(),new Comparator<ListNode>(){
        //     public int compare(ListNode s1, ListNode s2) {
        //       return s1.val-s2.val;
        // }});
        int mod= 1000000007;
        //start with node 1
       int[] visited=new int[A+1];
        for(Pair nbr:graph.get(1)){
            minheap.add(nbr);
        }
        visited[1]=1;
        long sum=0;
        while(!minheap.isEmpty()){
            Pair edgeselected=minheap.remove();
            int weight=edgeselected.weight;
            int nodeselected= edgeselected.nbrnode;
            if(visited[nodeselected]==0){
                sum= (sum+weight)%mod;
                visited[nodeselected]=1;
                for(Pair nbr:graph.get(nodeselected)){
                    if(visited[nbr.nbrnode]==0){
                    minheap.add(nbr);
                    }
                }
            }
        }
        return (int)sum;
    }
}

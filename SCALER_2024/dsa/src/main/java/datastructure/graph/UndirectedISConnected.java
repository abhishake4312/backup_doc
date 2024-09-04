package datastructure.graph;

public class UndirectedISConnected {
  
	static boolean union(int u,int v,int[] parent){
		int rootu=findroot(u,parent);
		int rootv=findroot(v,parent);
		if(rootu==rootv){
			return false;
		}else{
			parent[rootu]=rootv;
			return true;
		}
	}
	public static void main(String[] args){
		int n=6;
		int[] parent=new int[6];
		for(int i=0;i<n;i++){
			parent[i]=i;
		}
		int[][] edges={{0,1},{1,2},{2,0},{3,4},{4,5},{5,3}};
		int count=0;
		for(int i=0;i<edges.length;i++){
			int u=edges[i][0];
			int v=edges[i][1];
			if(union(u,v,parent)){
				count++;
			}
		}
		if(count==n-1){
			System.out.println("the graph is connected");
		}else{
			System.out.println("graph is not connected");
		}
	}
	static int findroot(int node,int[] parent){
		if(parent[node]==node){
			return node;
		}
		int x=findroot(parent[node],parent);
		parent[node]=x;
		return x;
	}
}

package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class TrianglesCount {
	
	static  public int singlepoint(int[] X, int[] Y) {
        int n=X.length;
        HashMap<Integer,Integer> hmX=new HashMap<Integer,Integer>();

        for(int i=0;i<n;i++){
            int key=X[i];
            if(hmX.containsKey(key)){
                int val=hmX.get(key);
                hmX.put(key,val+1);
            }else{
                hmX.put(key,1);
            }
        }
          HashMap<Integer,Integer> hmY=new HashMap<Integer,Integer>();

        for(int i=0;i<n;i++){
            int key=Y[i];
            if(hmY.containsKey(key)){
                int val=hmY.get(key);
                hmY.put(key,val+1);
            }else{
                hmY.put(key,1);
            }
        }
        long count=0;
        for(int i=0;i<n;i++){
            int x=X[i];
            int y=Y[i];
            long countYs= hmX.get(x);
            long countXs=hmY.get(y);
            count += (countYs-1)*(countXs-1);
        }
        int mod= (int)(Math.pow(10,9)+7);
        return (int)(count%mod);
    }
	public static int hypotenuseWay(int[] X, int[] Y) {

        int n=X.length;

        HashMap<Integer,HashSet<Integer>> hmX=new HashMap<Integer,HashSet<Integer>>();

        for(int i=0;i<n;i++){
            int key=X[i];
            if(hmX.containsKey(key)){
                HashSet<Integer> hs=hmX.get(key);
                hs.add(Y[i]);
                hmX.put(key,hs);
            }else{
                HashSet<Integer> hs=new HashSet<Integer>();
                hs.add(Y[i]);
                hmX.put(key,hs);
            }
        }
        long count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=X[i];
                int y1=Y[i];
                int x2=X[j];
                int y2=Y[j];
                HashSet<Integer> hs1=hmX.get(x1);
                HashSet<Integer> hs2=hmX.get(x2);
                if(x1!=x2 && y1!=y2){
                if(hs1.contains(y2)){
                    count++;
                }
                if(hs2.contains(y1)){
                    count++;
                }
                }
            }
        }
        int mod=(int)(Math.pow(10,9)+7);
        return (int)(count%mod);
    }
	public static void main(String[] args){
		int[] x={1,4,1,2,3,4};
		int[] y={3,3,1,0,1,1};
		
		System.out.println("hypotenuseWay "+hypotenuseWay(x,y));
		System.out.println("single point way "+singlepoint(x,y));
//		System.out.println("brute force "+countRectangleBruteForce(x,y));
//		System.out.println("hashmap way "+countRectangleHashMap(x,y));
	}
}

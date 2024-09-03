//package datastructure.Hashing;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//
//import javafx.util.Pair;
//
//public class RectangleCount {
//
//	public static int countRectanglesPairs(int[] X, int[] Y){
//
//		HashSet<Pair> hs=new HashSet<Pair>();
//		int n=X.length;
//
//		for(int i=0;i<n;i++){
//			hs.add(new Pair(X[i],Y[i]));
//		}
//		int count=0;
//		// Finding rectangle in all possible pair of diagonal
//		for(int i=0;i<n;i++){
//			for(int j=i+1;j<n;j++){
//				int diagx1=X[i];
//				int diagy1=Y[i];
//				int diagx2=X[j];
//				int diagy2=Y[j];
//
//				// To be sure diagonals are not parallel to xaxis and y-axis
//				if(diagx1!=diagx2 && diagy1!=diagy2){
//
//					Pair possiblepoint3= new Pair(diagx1,diagy2);
//					Pair possiblepoint4= new Pair(diagx2,diagy1);
//					if(hs.contains(possiblepoint3)&& hs.contains(possiblepoint4)){
//						count++;
//					}
//				}
//			}
//		}
//		return count/2;
//
//	}
//	public static int countRectangleHashMap(int[] X,int[] Y){
//		int n=X.length;
//
//		HashMap<Integer,HashSet<Integer>> hmX= new HashMap<Integer,HashSet<Integer>>();
//		for(int i=0;i<n;i++){
//			int key=X[i];
//			if(!hmX.containsKey(key)){
//				HashSet<Integer> ys= hmX.get(key);
//				ys.add(Y[i]);
//				hmX.put(key,ys);
//			}else{
//				HashSet<Integer> ys=new HashSet<Integer>();
//				ys.add(Y[i]);
//				hmX.put(key,ys);
//			}
//		}
//		HashMap<Integer,HashSet<Integer>> hmY= new HashMap<Integer,HashSet<Integer>>();
//		for(int i=0;i<n;i++){
//			int key=Y[i];
//			if(hmY.containsKey(key)){
//				HashSet<Integer> xs= hmY.get(key);
//				xs.add(X[i]);
//				hmY.put(key,xs);
//			}else{
//				HashSet<Integer> xs=new HashSet<Integer>();
//				xs.add(X[i]);
//				hmY.put(key,xs);
//			}
//		}
//		int count=0;
//		for(int i=0;i<n;i++){
//			for(int j=i+1;j<n;j++){
//				int x1=X[i];
//				int y1=Y[i];
//				int x2=X[j];
//				int y2=Y[j];
//				if(x1!=x2 && y1!=y2){
//					HashSet<Integer> ys=hmX.get(x1);
//
//					HashSet<Integer> xs=hmY.get(y1);
//
//					if(ys.contains(y2)&& xs.contains(x2)){
//						count++;
//					}
//				}
//			}
//		}
//		return count/2;
//	}
//	static boolean search(ArrayList<Integer> al,int val){
//		for(int i=0;i<al.size();i++){
//			if(al.get(i)==val){
//				return true;
//			}
//		}
//		return false;
//	}
//	static int countRectangleBruteForce(int[] X,int[] Y){
//		int n=X.length;
//		int count=0;
//		for(int i=0;i<n;i++){
//			for(int j=0;j<n;j++){
//				for(int k=0;k<n;k++){
//					for(int p=0;p<n;p++){
//						int x1=X[i];
//						int y1=Y[i];
//						int x2=X[j];
//						int y2=Y[j];
//						int x3=X[k];
//						int y3=Y[k];
//						int x4=X[p];
//						int y4=Y[p];
//						if((x1==x3)&& (x2==x4) && (y1==y2) && (y3==y4) && (x1!=x2) && (y1!=y3)){
//							count++;
//						}
//					}
//				}
//			}
//		}
//		return count/4;
//	}
//
//	public static void main(String[] args){
//		int[] x={-2,1,3,-2,1,3,0};
//		int[] y={3,3,3,1,1,1,-1};
//
//		System.out.println("hashset "+countRectanglesPairs(x,y));
//		System.out.println("brute force "+countRectangleBruteForce(x,y));
//		System.out.println("hashmap way "+countRectangleHashMap(x,y));
//	}
//}

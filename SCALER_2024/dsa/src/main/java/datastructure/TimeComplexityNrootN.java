package datastructure;

public class TimeComplexityNrootN {

	public static void main(String[] args){
		
		int N=10;
		for(int i=1;i<=N;i++){
			for(int j=1;j<=Math.sqrt(i);j++){
				System.out.println(j);
			}
		}
	}
}

package datastructure;

public class SPIRAL_N_M {
	
	static void printSpiral(int[][] A){
		int n=A.length;
		int m=A[0].length;
		int row=0;
		int col=0;
		while(n>1 && m>1){
			
			for(int k=0;k<m-1;k++){
				System.out.println(A[row][col]);
				col++;
			}
			for(int k=0;k<n-1;k++){
				System.out.println(A[row][col]);
				row++;
			}
			for(int k=0;k<m-1;k++){
				System.out.println(A[row][col]);
				col--;
			}
			for(int k=0;k<n-1;k++){
				System.out.println(A[row][col]);
				row--;
			}
			
			row++;
			col++;
			n=n-2;
			m=m-2;
		}
		
		if(n==1 && m==1){
			System.out.println(A[row][col]);
		}else if(n==1 && m>1){
			for(int i=0;i<m;i++){
				System.out.println(A[row][col]);
				col++;
			}
		}else if(m==1 && n>1){
			for(int i=0;i<n;i++){
				System.out.println(A[row][col]);
				row++;
			}
		}
	}
	
	public static void main(String[] args){
		
		//case 1 both even n=4 m=6
	//	int[][] a ={ {1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24}};
		
		//case 2 both odd n=3 m=5
	//	int[][] a ={ {1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		
		//case 3 one odd and one even and odd>even,n=7 m=4 making one =0
	//	int[][] a ={ {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24},{25,26,27,28}};
		
		//case 4 one odd and one even and even>odd n=6 and m=3
		int[][] a = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15},{16,17,18}};
		printSpiral(a);
	}

}

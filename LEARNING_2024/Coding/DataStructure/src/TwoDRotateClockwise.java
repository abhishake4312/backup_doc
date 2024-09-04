
public class TwoDRotateClockwise {
	
	public static void transpose(int[][]A){
		for(int i=0;i<A.length;i++){
			for(int j=i+1;j<A.length;j++){
				int tmp=A[i][j];
				A[i][j]=A[j][i];
				A[j][i]=tmp;
			}
		}
	}
	
	public static void reverse(int[] A){
		int i=0;
		int j=A.length-1;
		while(i<j){
			int tmp=A[i];
			A[i]=A[j];
			A[j]=tmp;
			i++;j--;
		}
	}
	
	public static void rotateClockwise(int[][] A, int degree){
		
		 degree= degree%360;
		 int rotationTimes = degree/90;
		 
		 for(int i=0;i<rotationTimes;i++){
			 
			 //transpose
			 transpose(A);
			 
			 for(int j=0;j<A.length;j++){
				 reverse(A[j]);
			 }
			 
		 }
		 
	}
	
	public static void rotateAntiClockwise(int[][] A, int degree){
		
		 degree= degree%360;
		 int clockWiseDegree=360-degree;
		 int rotationTimes = clockWiseDegree/90;
		 
		 for(int i=0;i<rotationTimes;i++){
			 
			 //transpose
			 transpose(A);
			 
			 for(int j=0;j<A.length;j++){
				 reverse(A[j]);
			 }
			 
		 }
		 
	}
	
	public static void main(String[] args){
		
		int[][] a = { {1,2},{3,4}};
		
		System.out.println("ORIGINAL ARRAY ");
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
//		rotateClockwise(a,630);
//		System.out.println("CLOCKWISE ROTATED ARRAY ");
//		for(int i=0;i<a.length;i++){
//			for(int j=0;j<a.length;j++){
//				System.out.print(a[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		rotateAntiClockwise(a,630);
		System.out.println("ANTICLOCKWISE ROTATED ARRAY ");
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}

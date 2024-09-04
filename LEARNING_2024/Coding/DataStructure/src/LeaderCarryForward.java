
public class LeaderCarryForward {
	public static int[] solve(int[] A) {
        int n=A.length;
        int rigthMostLeader=A[n-1];
        int[] leaderReturn=new int[A.length];
        int count=0;
        leaderReturn[count]=rigthMostLeader;

        for(int i=n-2;i>=0;i--){
            if(A[i]>rigthMostLeader){
                rigthMostLeader=A[i];
                count++;
                leaderReturn[count]=rigthMostLeader;
            }
        }
        return leaderReturn;
    }
	
	public static void main(String[] args){
		int[] a = {16,17,4,3,5,2};
		int[] ret=solve(a);
		for(int i=0;i<ret.length;i++){
			System.out.println(ret[i]);
		}
	}
}

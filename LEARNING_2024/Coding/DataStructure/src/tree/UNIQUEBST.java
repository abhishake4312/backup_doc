package tree;

public class UNIQUEBST {

}
public class Solution {
    private long[][] dp;
    private int A;

    public int numTrees(int A) {
        dp = new long[A][A];
        for (int i = 0; i < A; i++)
            Arrays.fill(dp[i], -1);
        this.A = A;
        return (int) rec(0, A - 1);
    }

    public long rec(int i, int j) {
        if (i < 0 || j < 0 || i >= A || j >= A)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i >= j)
            return dp[i][j] = 1;
        dp[i][j] = 0;
        for (int k = i; k <= j; k++) {
            dp[i][j] += (rec(i, k - 1) * rec(k + 1, j));
        }
        return dp[i][j];
    }

}
class Solution {
    private Integer[][] dp;
    private int[] ps;

    public int stoneGameV(int[] sv) {
        int n = sv.length;
        dp = new Integer[n][n];
        ps = new int[n + 1];

        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + sv[i];
        }
        return solve(0, n - 1);
    }

    private int solve(int i, int j) {
        if (i == j) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int res = 0;

        for (int k = i; k < j; k++) {
            int l = ps[k + 1] - ps[i];
            int r = ps[j + 1] - ps[k + 1];
            if (l < r) res = Math.max(res, l + solve(i, k));
            else if (r < l) res = Math.max(res, r + solve(k + 1, j));
            else res = Math.max(res, l + Math.max(solve(i, k), solve(k + 1, j)));
        }

        return dp[i][j] = res;
    }
}
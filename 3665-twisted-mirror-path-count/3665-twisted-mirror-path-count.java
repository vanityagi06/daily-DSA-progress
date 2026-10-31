class Solution {
    public int uniquePaths(int[][] g) {
        int m = g.length, n = g[0].length, MOD = 1_000_000_007;
        int[][][] go = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 2; d++) {
                    int r = i + (d == 1 ? 1 : 0), c = j + (d == 0 ? 1 : 0), dir = d;
                    while (r >= 0 && r < m && c >= 0 && c < n && g[r][c] == 1) {
                        if (dir == 0) { r++; dir = 1; }
                        else { c++; dir = 0; }
                    }
                    go[i][j][d] = (r >= 0 && r < m && c >= 0 && c < n) ? r * n + c : -1;
                }
            }
        }
        long[][] dp = new long[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;
                for (int d = 0; d < 2; d++) {
                    int t = go[i][j][d];
                    if (t != -1) {
                        dp[t / n][t % n] = (dp[t / n][t % n] + dp[i][j]) % MOD;
                    }
                }
            }
        }
        return (int) dp[m - 1][n - 1];
    }
}
class Solution {
    int m, n;
    char[][] g;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        if ((m + n - 1) % 2 != 0)
            return false;

        g = grid;
        dp = new Boolean[m][n][m + n];

        return dfs(0, 0, 0);
    }

    boolean dfs(int i, int j, int bal) {
        if (bal < 0)
            return false;

        bal += g[i][j] == '(' ? 1 : -1;

        if (bal < 0)
            return false;

        if (i == m - 1 && j == n - 1)
            return bal == 0;

        if (dp[i][j][bal] != null)
            return dp[i][j][bal];

        boolean res = false;

        if (i + 1 < m)
            res |= dfs(i + 1, j, bal);

        if (j + 1 < n)
            res |= dfs(i, j + 1, bal);

        return dp[i][j][bal] = res;
    }
}
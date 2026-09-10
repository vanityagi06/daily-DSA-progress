class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int c = 0;

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    c++;
                    dfs(grid, i, j);
                }
            }
        }
        return c;
    }

    public void dfs(char[][] g, int r, int c) {
        if (r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] == '0') {
            return;
        }

        g[r][c] = '0';

        dfs(g, r - 1, c);
        dfs(g, r + 1, c);
        dfs(g, r, c - 1);
        dfs(g, r, c + 1);
    }
}
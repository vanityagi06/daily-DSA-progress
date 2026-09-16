class Solution {
    public int numberOfSets(int n, int k) {
        int mod = 1000000007;
        int[] dp = new int[2 * k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n + k - 1; i++) {
            for (int j = Math.min(i, 2 * k); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % mod;
            }
        }

        return dp[2 * k];
    }
}
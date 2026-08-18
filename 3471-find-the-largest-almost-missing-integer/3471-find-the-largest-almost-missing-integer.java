class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length, ans = -1;

        if (k == 1) {
            int[] cnt = new int[51];
            for (int x : nums) cnt[x]++;
            for (int i = 0; i <= 50; i++) {
                if (cnt[i] == 1) ans = Math.max(ans, i);
            }
            return ans;
        }
        if (k == n) {
            for (int x : nums) ans = Math.max(ans, x);
            return ans;
        }
        int c1 = 0, c2 = 0;
        for (int x : nums) {
            if (x == nums[0]) c1++;
            if (x == nums[n - 1]) c2++;
        }
        if (c1 == 1) ans = Math.max(ans, nums[0]);
        if (c2 == 1) ans = Math.max(ans, nums[n - 1]);

        return ans;
    }
}
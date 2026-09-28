class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = 1_000_000_007;

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % m;
        }

        int c = 0;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                c = (c + pow[r - l]) % m;
                l++;
            } else {
                r--;
            }
        }

        return c;
    }
}
class Solution {
    public int firstStableIndex(int[] nums, int x) {
        int n = nums.length;
        int[] smin = new int[n];
        smin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) smin[i] = Math.min(smin[i + 1], nums[i]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) max = nums[i];
            if (max - smin[i] <= x) return i;
        }
        return -1;
    }
}
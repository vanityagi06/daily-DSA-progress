class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int c = 0;
        int n = nums.length;

        for (int k = n - 1; k >= 2; k--) {
            int l = 0;
            int r = k - 1;

            while (l < r) {
                if (nums[l] + nums[r] > nums[k]) {
                    c += (r - l);
                    r--;
                } else {
                    l++;
                }
            }
        }

        return c;
    }
}
import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int c = 0;

        for (int x : nums) {
            int l = 0;
            int r = c;

            while (l < r) {
                int m = l + (r - l) / 2;
                if (tails[m] >= x) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }

            tails[l] = x;
            if (l == c) {
                c++;
            }
        }

        return c;
    }
}
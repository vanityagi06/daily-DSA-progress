import java.util.Arrays;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] s = new int[n][2];
        for (int i = 0; i < n; i++) {
            s[i][0] = intervals[i][0];
            s[i][1] = i;
        }
        
        Arrays.sort(s, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int t = intervals[i][1];
            int l = 0, r = n - 1;
            int idx = -1;
            
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (s[m][0] >= t) {
                    idx = s[m][1];
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            res[i] = idx;
        }
        return res;
    }
}
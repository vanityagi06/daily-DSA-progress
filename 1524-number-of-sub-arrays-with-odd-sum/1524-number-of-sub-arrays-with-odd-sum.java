class Solution {
    public int numOfSubarrays(int[] arr) {
        int c = 0, o = 0, e = 1, s = 0;
        int m = 1_000_000_007;
        for (int x : arr) {
            s += x;
            if (s % 2 == 1) {
                c = (c + e) % m;
                o++;
            } else {
                c = (c + o) % m;
                e++;
            }
        }
        return c;
    }
}
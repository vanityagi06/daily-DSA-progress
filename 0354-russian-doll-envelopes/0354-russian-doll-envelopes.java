class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        
        int[] tails = new int[envelopes.length];
        int c = 0;

        for (int[] env : envelopes) {
            int height = env[1];
            int l = 0;
            int r = c;

            while (l < r) {
                int m = l + (r - l) / 2;
                if (tails[m] >= height) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }

            tails[l] = height;
            if (l == c) {
                c++;
            }
        }

        return c;
    }
}
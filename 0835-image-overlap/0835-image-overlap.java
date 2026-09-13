class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int res = 0;

        for (int x = -n + 1; x < n; x++) {
            for (int y = -n + 1; y < n; y++) {
                int c = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int p = i + x;
                        int q = j + y;

                        if (p >= 0 && p < n && q >= 0 && q < n &&
                            img1[i][j] == 1 && img2[p][q] == 1)
                            c++;
                    }
                }

                res = Math.max(res, c);
            }
        }

        return res;
    }
}
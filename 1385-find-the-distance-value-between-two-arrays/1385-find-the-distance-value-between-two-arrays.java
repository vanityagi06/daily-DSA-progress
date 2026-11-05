class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c = 0;
        java.util.Arrays.sort(arr2);
        for (int x : arr1) {
            int l = 0, r = arr2.length - 1;
            boolean ok = true;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (Math.abs(arr2[m] - x) <= d) {
                    ok = false;
                    break;
                }
                if (arr2[m] < x) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            if (ok) {
                c++;
            }
        }
        return c;
    }
}
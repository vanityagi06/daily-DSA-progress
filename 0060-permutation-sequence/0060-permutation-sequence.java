class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] * i;
            num.add(i);
        }
        num.add(n);

        k--;

        StringBuilder res = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int index = k / f[i - 1];
            res.append(num.get(index));
            num.remove(index);
            k %= f[i - 1];
        }
        return res.toString();
    }
}
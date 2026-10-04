class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] c = new int[n];
        Arrays.fill(c, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                c[i] = c[i - 1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                c[i] = Math.max(c[i], c[i + 1] + 1);
            }
        }
        int s = 0; 
        for(int i = 0; i < n; i++){
            s += c[i];
        }
        return s;
    }
}
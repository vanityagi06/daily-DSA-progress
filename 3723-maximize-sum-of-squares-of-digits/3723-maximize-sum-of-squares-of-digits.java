class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 0 || sum > 9 * num) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int cur = Math.min(9, sum);
            sb.append(cur);
            sum -= cur;
        }

        if(sum == 0) return sb.toString();
        else return "";
        //return sum == 0 ? sb.toString() : "";
    }
}
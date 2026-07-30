class Solution {
    public int minimumPushes(String word) {
        //(i / 8) + 1
        int res = 0;
        for(int i = 0; i < word.length(); i++){
            res += (i / 8) + 1;
        }
        return res;
    }
}
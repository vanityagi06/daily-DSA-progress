class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> r = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    r.add(1);
                }
                else{
                    List<Integer> x = res.get(i - 1);
                    int s = x.get(j - 1) + x.get(j);
                    r.add(s);
                }
            }
            res.add(r);
        }
        return res;
    }
}
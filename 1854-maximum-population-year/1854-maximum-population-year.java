class Solution {
    public int maximumPopulation(int[][] logs) {
        HashMap<Integer, Integer> m = new HashMap<>();

        int c = 0;
        int res = 0;

        for(int[] i : logs){
            for(int j = i[0]; j < i[1]; j++){
                m.put(j, m.getOrDefault(j, 0) + 1);
            }
        }

        for(int i = 1950; i <= 2050; i++){
            if(m.getOrDefault(i, 0) > c){
                c = m.get(i);
                res = i;
            }
        }

        return res;
    }
}
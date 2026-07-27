class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jew = new HashSet<>();

        HashMap<Character, Integer> stn = new HashMap<>();

        int res = 0;

        for(char c : stones.toCharArray()){
            stn.put(c, stn.getOrDefault(c , 0) + 1);
        }

        for(char c : jewels.toCharArray()){
            jew.add(c);
        }
        for(char c : jew){
            if(stn.containsKey(c)){
                res += stn.get(c);
            }
        }
        return res;

    }
}
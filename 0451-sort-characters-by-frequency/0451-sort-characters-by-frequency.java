class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        StringBuilder str = new StringBuilder();

        for(char c : s.toCharArray()){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        //bucket sort --
        List<Character>[] b = new List[s.length() + 1];
        for(char c : m.keySet()){
            int freq = m.get(c);

            if(b[freq] == null){
                b[freq] = new ArrayList<>();
            }
            b[freq].add(c);
        }

        for(int i = b.length - 1; i > 0; i--){
            if(b[i] != null){
                for(char c : b[i]){
                    for(int j = 0; j < i; j++){
                        str.append(c);
                    }
                }
            }
        }


        return str.toString();
    }
}
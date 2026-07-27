class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> m = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char S = s.charAt(i);
            char T = t.charAt(i);

            if(m.containsKey(S)){
                if(m.get(S) != T){
                    return false;
                }
            } else{
                if(m.containsValue(T)){
                    return false;
                }
                m.put(S, T);
            }
        }
        return true;
    }
}
class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if(n != goal.length()) return false;
        if(s.equals(goal)) return true;
        for(int i = 0; i < n; i++){
            boolean match = true;
            for(int j = 0; j < n; j++){
                if(s.charAt((i + j) % n) != goal.charAt(j)){
                    match = false;
                    break;
                }
            }
            if(match) return true;
        }
        return false;
    }
}
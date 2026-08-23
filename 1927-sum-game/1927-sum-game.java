class Solution {
    public boolean sumGame(String num) {
        int a = 0;
        int b = 0;
        int x = 0;
        int y = 0;

        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '?'){
                if(i < num.length() / 2) x++;
                else y++;
            }
            else{
                if(i < num.length() / 2) a += num.charAt(i) - '0';
                else b += num.charAt(i) - '0';
            }
        }

        if((x + y) % 2 != 0) return true;

        return a - b != 9 * (y - x) / 2;
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        int rem;
        int original = x;
        int c_org = x;
        long newNo = 0;
        int count = 0;
        
        while(c_org > 0){
            c_org = c_org/10;
            count++;
        }
        int n = count;

         for(int i = 1; i <=n; i++){
            rem = x % 10;
            newNo += rem * Math.pow(10, n-i);
            x = x/10;
         }

         if(original == newNo){
            return true;
         }
         return false;


    }
}
class Solution {
    public int maxProduct(int n) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        while(n > 0){
            int rem = n%10;
            arr.add(rem);
            n = n / 10;
        }

        Collections.sort(arr);

        return arr.get(arr.size()-2)*arr.get(arr.size() - 1);
    }
}
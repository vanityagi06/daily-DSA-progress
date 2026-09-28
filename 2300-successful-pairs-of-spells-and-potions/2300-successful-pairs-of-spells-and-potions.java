import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int c = potions.length;
        int[] pairs = new int[n];

        for (int i = 0; i < n; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i];
            
            int l = 0;
            int r = c;
            
            while (l < r) {
                int m = l + (r - l) / 2;
                if (potions[m] >= minPotion) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            
            pairs[i] = c - l;
        }

        return pairs;
    }
}